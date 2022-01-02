package com.iohao.little.game.net.gateway.widget.broadcast;

import com.iohao.little.game.action.skeleton.protocol.ResponseMessage;
import com.iohao.little.game.net.message.common.BroadcastMessage;
import com.iohao.little.game.net.server.GateKit;
import com.iohao.little.game.widget.broadcast.MessageListenerWidget;
import com.iohao.little.game.widget.broadcast.MessageQueueWidget;
import com.iohao.little.game.widget.config.WidgetComponents;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BroadcastMessageListenerWidget implements MessageListenerWidget<ResponseMessage> {
    @Override
    public CharSequence channel() {
        return "internal_channel";
    }

    @Override
    public void onMessage(ResponseMessage responseMessage, CharSequence channel, BroadcastMessage broadcastMessage) {

        WidgetComponents widgetComponents = GateKit.boltServer.getWidgetComponents();
        MessageQueueWidget option = widgetComponents.option(MessageQueueWidget.class);
        log.info("当前使用的发布订阅内核是: {}", option.getClass());
        log.info("网关 Broadcast 正在处理 {}", responseMessage);
    }
}