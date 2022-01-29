package com.iohao.little.game.net.message.common;

import com.iohao.little.game.action.skeleton.protocol.ResponseMessage;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

/**
 * 广播消息
 */
@Data
public class BroadcastMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = -8781053474740658678L;

    /** 广播的消息 */
    ResponseMessage responseMessage;
    /** 接收广播的用户列表 */
    Collection<Long> userIdList;
    /** true 给全体广播 */
    boolean broadcastAll;

}