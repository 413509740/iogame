/*
 * # iohao.com . 渔民小镇
 * Copyright (C) 2021 - 2022 double joker （262610965@qq.com） . All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License..
 */
package com.iohao.game.bolt.broker.client.external.bootstrap;

import com.alipay.remoting.exception.RemotingException;
import com.alipay.remoting.rpc.RpcCommandType;
import com.iohao.game.action.skeleton.core.CmdKit;
import com.iohao.game.action.skeleton.core.DataCodecKit;
import com.iohao.game.action.skeleton.core.commumication.BrokerClientContext;
import com.iohao.game.action.skeleton.protocol.HeadMetadata;
import com.iohao.game.action.skeleton.protocol.RequestMessage;
import com.iohao.game.action.skeleton.protocol.ResponseMessage;
import com.iohao.game.bolt.broker.client.external.ExternalHelper;
import com.iohao.game.bolt.broker.client.external.bootstrap.message.ExternalMessage;
import com.iohao.game.bolt.broker.client.external.bootstrap.message.ExternalMessageCmdCode;
import com.iohao.game.bolt.broker.client.external.session.UserSession;
import com.iohao.game.bolt.broker.client.external.session.UserSessions;
import com.iohao.game.bolt.broker.core.client.BrokerClient;
import com.iohao.game.bolt.broker.core.message.BrokerClientModuleMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.experimental.UtilityClass;

/**
 * @author 渔民小镇
 * @date 2022-01-18
 */
@UtilityClass
public class ExternalKit {
    public RequestMessage convertRequestMessage(ExternalMessage message) {

        int cmdMerge = message.getCmdMerge();
        byte[] data = message.getData();

        return createRequestMessage(cmdMerge, data);
    }

    /**
     * 创建请求消息
     *
     * @param cmdMerge 路由 {@link CmdKit#merge(int, int)}
     * @param data     业务数据
     * @return 请求消息
     */
    public RequestMessage createRequestMessage(int cmdMerge, Object data) {
        byte[] bytes = null;

        if (data != null) {
            bytes = DataCodecKit.encode(data);
        }

        return createRequestMessage(cmdMerge, bytes);
    }

    /**
     * 创建请求消息
     *
     * @param cmdMerge 路由 {@link CmdKit#merge(int, int)}
     * @return 请求消息
     */
    public RequestMessage createRequestMessage(int cmdMerge) {
        return createRequestMessage(cmdMerge, null);
    }

    /**
     * 创建请求消息
     *
     * @param cmdMerge 路由 {@link CmdKit#merge(int, int)}
     * @param data     业务数据 byte[]
     * @return 请求消息
     */
    public RequestMessage createRequestMessage(int cmdMerge, byte[] data) {

        BrokerClient brokerClient = (BrokerClient) ExternalHelper.me().getBrokerClient();

        BrokerClientModuleMessage brokerClientModuleMessage = brokerClient.getBrokerClientModuleMessage();

        int idHash = brokerClientModuleMessage.getIdHash();

        // 元信息
        HeadMetadata headMetadata = new HeadMetadata()
                .setCmdMerge(cmdMerge)
                .setRpcCommandType(RpcCommandType.REQUEST_ONEWAY)
                .setSourceClientId(idHash);

        // 请求
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setHeadMetadata(headMetadata);

        requestMessage.setData(data);

        return requestMessage;
    }

    public ExternalMessage convertExternalMessage(ResponseMessage responseMessage) {
        HeadMetadata headMetadata = responseMessage.getHeadMetadata();

        ExternalMessage externalMessage = new ExternalMessage();
        externalMessage.setCmdCode(ExternalMessageCmdCode.biz);
        externalMessage.setCmdMerge(headMetadata.getCmdMerge());
        externalMessage.setResponseStatus(responseMessage.getResponseStatus());
        externalMessage.setData(responseMessage.getData());
        externalMessage.setValidMsg(responseMessage.getValidatorMsg());

        return externalMessage;
    }

    public void writeAndFlush(long userId, ExternalMessage message) {

        if (!UserSessions.me().existUserSession(userId)) {
            return;
        }

        UserSession userSession = UserSessions.me().getUserSession(userId);

        Channel channel = userSession.getChannel();

        channel.writeAndFlush(message);
    }

    /**
     * 请求游戏网关
     *
     * @param ctx            ctx
     * @param requestMessage 请求消息
     * @throws RemotingException e
     */

    public void requestGateway(ChannelHandlerContext ctx, RequestMessage requestMessage) throws RemotingException {
        UserSession userSession = UserSessions.me().getUserSession(ctx);
        requestGateway(userSession, requestMessage);
    }

    public void requestGateway(UserSession userSession, RequestMessage requestMessage) throws RemotingException {
        // 给请求消息加上一些 user 自身的数据
        userSession.employ(requestMessage);

        // 由内部逻辑服转发用户请求到游戏网关，在由网关转到具体的业务逻辑服
        BrokerClientContext brokerClient = ExternalHelper.me().getBrokerClient();
        brokerClient.oneway(requestMessage);
    }
}
