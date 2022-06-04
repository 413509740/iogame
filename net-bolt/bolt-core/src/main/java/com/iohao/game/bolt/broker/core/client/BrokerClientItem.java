/*
 * # iohao.com . 渔民小镇
 * Copyright (C) 2021 - 2022 double joker （262610965@qq.com） . All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.iohao.game.bolt.broker.core.client;

import com.alipay.remoting.Connection;
import com.alipay.remoting.ConnectionEventProcessor;
import com.alipay.remoting.ConnectionEventType;
import com.alipay.remoting.config.BoltClientOption;
import com.alipay.remoting.exception.RemotingException;
import com.alipay.remoting.rpc.RpcClient;
import com.alipay.remoting.rpc.protocol.UserProcessor;
import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.commumication.BroadcastContext;
import com.iohao.game.action.skeleton.core.commumication.ProcessorContext;
import com.iohao.game.action.skeleton.protocol.RequestMessage;
import com.iohao.game.action.skeleton.protocol.ResponseMessage;
import com.iohao.game.action.skeleton.protocol.collect.RequestCollectMessage;
import com.iohao.game.action.skeleton.protocol.collect.ResponseCollectMessage;
import com.iohao.game.action.skeleton.protocol.processor.ExtRequestMessage;
import com.iohao.game.bolt.broker.core.aware.BrokerClientAware;
import com.iohao.game.bolt.broker.core.aware.BrokerClientItemAware;
import com.iohao.game.bolt.broker.core.common.BrokerGlobalConfig;
import com.iohao.game.bolt.broker.core.message.BrokerClientItemConnectMessage;
import com.iohao.game.bolt.broker.core.message.BrokerClientModuleMessage;
import com.iohao.game.bolt.broker.core.message.InnerModuleMessage;
import com.iohao.game.common.kit.MurmurHash3;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * 客户连接项
 * <pre>
 *     与游戏网关是 1:1 的关系
 * </pre>
 *
 * @author 渔民小镇
 * @date 2022-05-14
 */
@Slf4j
@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrokerClientItem implements BroadcastContext, ProcessorContext {


    public enum Status {
        /** 活跃 */
        ACTIVE,
        /** 断开：与网关断开了 */
        DISCONNECT;
    }

    final RpcClient rpcClient;
    /** 广播 */
    final Broadcast broadcast = new Broadcast(this);

    /** 与 broker 通信的连接 */
    Connection connection;
    String address;
    /** 消息发送超时时间 */
    int timeoutMillis = BrokerGlobalConfig.timeoutMillis;
    /** 业务框架 */
    BarSkeleton barSkeleton;
    /** broker 的 client */
    BrokerClient brokerClient;

    Status status = Status.DISCONNECT;

    public BrokerClientItem(String address) {
        this.address = address;
        this.rpcClient = new RpcClient();
        // 重连选项
        rpcClient.option(BoltClientOption.CONN_RECONNECT_SWITCH, true);
        rpcClient.option(BoltClientOption.CONN_MONITOR_SWITCH, true);
    }

    public Object invokeSync(final Object request, final int timeoutMillis) throws RemotingException, InterruptedException {
        return rpcClient.invokeSync(connection, request, timeoutMillis);
    }

    public Object invokeSync(final Object request) throws RemotingException, InterruptedException {
        return invokeSync(request, timeoutMillis);
    }

    public void oneway(final Object request) throws RemotingException {
        this.rpcClient.oneway(connection, request);
    }

    void invokeWithCallback(Object request) throws RemotingException {
        this.rpcClient.invokeWithCallback(connection, request, null, timeoutMillis);
    }

    @Override
    public void broadcast(ResponseMessage responseMessage, Collection<Long> userIdList) {
        this.broadcast.broadcast(responseMessage, userIdList);
    }

    @Override
    public void broadcast(ResponseMessage responseMessage, long userId) {
        this.broadcast.broadcast(responseMessage, userId);
    }

    @Override
    public void broadcast(ResponseMessage responseMessage) {
        this.broadcast.broadcast(responseMessage);
    }

    public ResponseMessage invokeModuleMessage(RequestMessage requestMessage) {
        InnerModuleMessage moduleMessage = new InnerModuleMessage();
        moduleMessage.setRequestMessage(requestMessage);

        ResponseMessage o = null;

        try {
            o = (ResponseMessage) this.invokeSync(moduleMessage);
        } catch (RemotingException | InterruptedException e) {
            e.printStackTrace();
        }

        return o;
    }

    public ResponseCollectMessage invokeModuleCollectMessage(RequestMessage requestMessage) {
        RequestCollectMessage requestCollectMessage = new RequestCollectMessage()
                .setRequestMessage(requestMessage);

        try {
            return (ResponseCollectMessage) this.invokeSync(requestCollectMessage);
        } catch (RemotingException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void invokeOneway(Object message) {
        this.internalOneway(message);
    }

    @Override
    public void invokeOneway(ExtRequestMessage message) {
        String id = this.brokerClient.getId();
        int hash32 = MurmurHash3.hash32(id);
        message.setSourceClientId(hash32);

        this.internalOneway(message);
    }

    void addConnectionEventProcessor(ConnectionEventType type, ConnectionEventProcessor processor) {

        aware(processor);

        this.rpcClient.addConnectionEventProcessor(type, processor);
    }

    void registerUserProcessor(UserProcessor<?> processor) {

        aware(processor);

        this.rpcClient.registerUserProcessor(processor);
    }

    private void aware(Object obj) {
        if (obj instanceof BrokerClientItemAware aware) {
            aware.setBrokerClientItem(this);
        }

        if (obj instanceof BrokerClientAware aware) {
            aware.setBrokerClient(brokerClient);
        }

    }

    private void internalOneway(Object responseObject) {
        try {
            rpcClient.oneway(connection, responseObject);
        } catch (RemotingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册到网关 broker
     * 客户端服务器注册到网关服
     */
    public void registerToBroker() {
        // 客户端服务器注册到游戏网关服
        BrokerClientModuleMessage brokerClientModuleMessage = this.brokerClient.getBrokerClientModuleMessage();

        if (BrokerGlobalConfig.openLog) {
            log.info("逻辑服发模块信息给 broker （游戏网关） : {}", brokerClientModuleMessage.toJsonPretty());
        }

        try {

            this.rpcClient.oneway(address, brokerClientModuleMessage);

            TimeUnit.MILLISECONDS.sleep(100);
            this.status = Status.ACTIVE;
            this.brokerClient.getBrokerClientManager().resetSelector();

        } catch (RemotingException | InterruptedException e) {
            e.printStackTrace();
            String errMsg = "RemotingException caught in oneway! address:" + address;
            log.error(errMsg);
        }
    }

    public void startup() {
        this.rpcClient.startup();
        this.send();
    }

    private void send() {
        BrokerClientItemConnectMessage message = new BrokerClientItemConnectMessage();
        try {
            this.rpcClient.oneway(address, message);
        } catch (RemotingException | InterruptedException e) {
            e.printStackTrace();
            String errMsg = "RemotingException caught in oneway! address:" + address;
            log.error(errMsg);
        }
    }
}
