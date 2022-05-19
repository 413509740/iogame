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
package com.iohao.game.bolt.broker.client;

import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.bolt.broker.core.client.*;
import com.iohao.game.bolt.broker.core.common.BrokerGlobalConfig;
import com.iohao.game.common.kit.NetworkKit;

/**
 * BoltBrokerClient 的配置
 *
 * @author 渔民小镇
 * @date 2022-04-29
 */
public sealed interface BrokerClientStartup permits AbstractBrokerClientStartup {
    /**
     * 初始化 业务框架
     *
     * @return 业务框架
     */
    BarSkeleton createBarSkeleton();

    /**
     * BoltBrokerClient 构建器
     *
     * <pre>
     *     see {@link BrokerClient#newBuilder()}
     * </pre>
     *
     * @return 构建器
     */
    BrokerClientBuilder createBrokerClientBuilder();

    /**
     * 初始化 远程连接地址 （连接到游戏网关的地址）
     * <pre>
     *     地址格式:  ip:port
     *     如: 127.0.0.1:10200
     *
     *     默认方法中提供了本地连接 broker（游戏网关） 的地址
     *     如果不能满足业务的，可以重写此方法
     * </pre>
     *
     * @return 远程连接地址
     */
    default BrokerAddress createBrokerAddress() {
        // 类似 127.0.0.1 ，但这里是本机的 ip
        String localIp = NetworkKit.LOCAL_IP;
        // broker （游戏网关）默认端口
        int brokerPort = BrokerGlobalConfig.brokerPort;
        return new BrokerAddress(localIp, brokerPort);
    }

    /**
     * 添加连接处理器
     * <pre>
     *     see:
     *     {@link com.alipay.remoting.ConnectionEventType#CLOSE}
     *     {@link com.alipay.remoting.ConnectionEventType#CONNECT}
     *
     *     默认方法中提供了一些比较通用的连接处理器，如果不能满足业务的，可以重写此方法
     * </pre>
     *
     * @param brokerClientBuilder boltBrokerClientBuilder
     */
    void connectionEventProcessor(BrokerClientBuilder brokerClientBuilder);

    /**
     * 注册用户处理器
     * <pre>
     *     默认方法中提供了一些比较通用的用户处理器，如果不能满足业务的，可以重写此方法
     * </pre>
     *
     * @param brokerClientBuilder boltBrokerClientBuilder
     */
    void registerUserProcessor(BrokerClientBuilder brokerClientBuilder);

    /**
     * BrokerClient 启动后的钩子方法
     * <pre>
     *     如果有需要，可以在这里 保存一下 BrokerClient 的引用
     *
     *     框架会在逻辑服启动时，在 {@link BrokerClientHelper} 中保存了一份 BrokerClient 的引用
     * </pre>
     *
     * @param brokerClient BrokerClient
     */
    default void startupSuccess(BrokerClient brokerClient) {
        // 对于 brokerClient 的引用使用，建议用 BrokerClientHolder
        BrokerClients.me().put(this.getClass(), brokerClient);
    }

    /**
     * 启动
     *
     * @return BoltBrokerClient
     */
    default BrokerClient startup() {
        return BrokerClientService.me().start(this);
    }

}
