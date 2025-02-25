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
package com.iohao.game.action.skeleton.core.flow.parser;

import com.iohao.game.action.skeleton.core.ActionCommand;
import com.iohao.game.action.skeleton.core.DataCodecKit;
import com.iohao.game.action.skeleton.protocol.wrapper.LongListPb;
import com.iohao.game.action.skeleton.protocol.wrapper.LongPb;

import java.util.List;

/**
 * @author 渔民小镇
 * @date 2022-06-26
 */
final class LongMethodParser implements MethodParser {

    @Override
    public Class<?> getActualClazz(ActionCommand.MethodParamResultInfo methodParamResultInfo) {
        return methodParamResultInfo.isList() ? LongListPb.class : LongPb.class;
    }

    @Override
    public Object parseParam(byte[] data, ActionCommand.ParamInfo paramInfo) {
        if (paramInfo.isList()) {
            LongListPb longListPb = DataCodecKit.decode(data, LongListPb.class);
            return longListPb.longValues;
        }

        LongPb longPb = DataCodecKit.decode(data, LongPb.class);
        return longPb.longValue;
    }

    @Override
    public Object parseResult(ActionCommand.ActionMethodReturnInfo actionMethodReturnInfo, Object methodResult) {
        if (actionMethodReturnInfo.isList()) {
            LongListPb longListPb = new LongListPb();
            longListPb.longValues = (List<Long>) methodResult;
            return longListPb;
        } else {
            // 将结果转换为 intPb
            LongPb longPb = new LongPb();
            longPb.longValue = (long) methodResult;
            return longPb;
        }

    }


    private LongMethodParser() {

    }

    public static LongMethodParser me() {
        return Holder.ME;
    }


    /** 通过 JVM 的类加载机制, 保证只加载一次 (singleton) */
    private static class Holder {
        static final LongMethodParser ME = new LongMethodParser();
    }
}
