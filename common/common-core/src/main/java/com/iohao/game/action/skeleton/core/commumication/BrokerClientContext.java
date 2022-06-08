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
package com.iohao.game.action.skeleton.core.commumication;

import com.alipay.remoting.AsyncContext;
import com.alipay.remoting.exception.RemotingException;
import com.iohao.game.action.skeleton.protocol.RequestMessage;
import com.iohao.game.action.skeleton.protocol.ResponseMessage;
import com.iohao.game.action.skeleton.protocol.collect.ResponseCollectMessage;

/**
 * 当前服务器上下文
 * <pre>
 *     see BrokerClientHelper
 * </pre>
 *
 * @author 渔民小镇
 * @date 2021-12-20
 */
public interface BrokerClientContext extends AsyncContext {

    /**
     * 发送消息到游戏网关
     *
     * @param request 消息
     * @throws RemotingException e
     */
    void oneway(final Object request) throws RemotingException;

    /**
     * 得到广播通讯上下文
     *
     * @return 广播通讯上下文
     */
    BroadcastContext getBroadcastContext();

    /**
     * 得到 processor 上下文
     *
     * @return processor 上下文
     */
    ProcessorContext getProcessorContext();

    /**
     * 得到 内部模块通讯上下文
     *
     * @return 内部模块通讯上下文
     */
    InvokeModuleContext getInvokeModuleContext();

    /**
     * 根据路由信息来请求其他子服务器（其他逻辑服）的数据
     * <pre>
     *     请用 {@link InvokeModuleContext#invokeModuleMessage(RequestMessage)}
     * </pre>
     *
     * @param requestMessage requestMessage
     * @return ResponseMessage
     */
    @Deprecated
    ResponseMessage invokeModuleMessage(RequestMessage requestMessage);

    /**
     * 模块之间的访问，访问【同类型】的多个逻辑服
     * <pre>
     *     模块A 访问 模块B 的某个方法，因为只有模块B持有这些数据，这里的模块指的是逻辑服。
     *     假设启动了多个模块B，分别是：模块B-1、模块B-2、模块B-3、模块B-4 等。框架支持访问【同类型】的多个逻辑服，并把多个相同逻辑服结果收集到一起。
     *
     *     具体的意思可以参考文档中的说明
     *     https://www.yuque.com/iohao/game/rf9rb9
     * </pre>
     * <pre>
     *     请用 {@link InvokeModuleContext#invokeModuleCollectMessage(RequestMessage)}
     * </pre>
     * @param requestMessage requestMessage
     * @return ResponseAggregationMessage
     */
    @Deprecated
    ResponseCollectMessage invokeModuleCollectMessage(RequestMessage requestMessage);
}
