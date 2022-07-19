package com.hgz.optim.msg;

import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQListener;

import java.nio.charset.StandardCharsets;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/10 16:12
 */
@Log4j2
public abstract class RocketStringMessageListener<T> implements RocketMQListener<MessageExt> {


    @Override
    public void onMessage(MessageExt messageExt) {
        String topic = messageExt.getTopic();
        String tags = messageExt.getTags();
        String keys = messageExt.getKeys();
        String msgId = messageExt.getMsgId();
        String message = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        log.info("MQ消息topic:{},tags:{},keys:{},msgId:{},message:{}", topic, tags, keys, msgId, message);
        try {
            messageData(tags, message);
            log.info("MQ消息keys:{},处理成功", keys);
        } catch (Exception e) {
            log.error("MQ消息keys:{}处理异常", keys);
        }
    }

    public abstract void messageData(String tag, String message);
}
