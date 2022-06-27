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
package com.iohao.game.action.skeleton.core.flow.interal;

import com.iohao.game.action.skeleton.core.ActionCommand;
import com.iohao.game.action.skeleton.core.exception.MsgException;
import com.iohao.game.action.skeleton.core.flow.ActionMethodResultWrap;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import com.iohao.game.action.skeleton.core.flow.attr.FlowAttr;
import com.iohao.game.action.skeleton.core.flow.parser.MethodParser;
import com.iohao.game.action.skeleton.core.flow.parser.MethodParsers;
import com.iohao.game.action.skeleton.protocol.ResponseMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * 结果包装器
 *
 * @author 渔民小镇
 * @date 2022-01-12
 */
@Slf4j
public final class DefaultActionMethodResultWrap implements ActionMethodResultWrap {
    @Override
    public void wrap(final FlowContext flowContext) {
        final ResponseMessage responseMessage = flowContext.getResponse();
        // 业务方法的返回值
        final Object result = flowContext.getMethodResult();

        // 如果有异常错误，异常处理
        if (flowContext.isError()) {

            MsgException msgException = (MsgException) result;
            int code = msgException.getMsgCode();
            responseMessage.setResponseStatus(code);

            flowContext.option(FlowAttr.msgException, msgException.getMessage());

            return;
        }

        ActionCommand.ActionMethodReturnInfo actionMethodReturnInfo = flowContext.getActionCommand().getActionMethodReturnInfo();

        // （action 返回值是 void 或者结果是 null ）不做处理
        if (actionMethodReturnInfo.isVoid() || result == null) {
            return;
        }

        MethodParser paramParser = MethodParsers.me().getMethodParser(actionMethodReturnInfo);

        // 根据返回值类型
        Object methodResult = paramParser.parseResult(actionMethodReturnInfo, result);
        // 重新赋值一下 methodResult 到 flowContext 中，方便在 DebugInOut 中的打印
        flowContext.setMethodResult(methodResult);

        // 业务方法返回值
        responseMessage.setData(methodResult);
    }


    private DefaultActionMethodResultWrap() {

    }

    public static DefaultActionMethodResultWrap me() {
        return Holder.ME;
    }

    /** 通过 JVM 的类加载机制, 保证只加载一次 (singleton) */
    private static class Holder {
        static final DefaultActionMethodResultWrap ME = new DefaultActionMethodResultWrap();
    }
}
