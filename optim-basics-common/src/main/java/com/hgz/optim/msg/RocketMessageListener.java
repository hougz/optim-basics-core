package com.hgz.optim.msg;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.core.ResolvableType;

import java.nio.charset.StandardCharsets;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/10 16:44
 */
@Log4j2
public abstract class RocketMessageListener<T> implements RocketMQListener<MessageExt> {

    private final Class<T> clazz = (Class<T>) ResolvableType.forClass(getClass()).as(RocketMessageListener.class).getGeneric(0).resolve();

    @Override
    public void onMessage(MessageExt messageExt) {
        String topic = messageExt.getTopic();
        String tags = messageExt.getTags();
        String keys = messageExt.getKeys();
        String msgId = messageExt.getMsgId();
        String message = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        log.info("MQ消息topic:{},tags:{},keys:{},msgId:{},message:{}", topic, tags, keys, msgId, message);
        try {
            T msg = JSONObject.parseObject(message, clazz);
            messageData(tags, msg);
            log.info("MQ消息keys:{},处理成功", keys);
        } catch (Exception e) {
            log.error("MQ消息keys:{}处理异常", keys);
        }
    }

    /**
     * 消息处理类
     *
     * @param tag
     * @param message
     */
    public abstract void messageData(String tag, T message);
}
