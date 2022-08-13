package com.hgz.optim.msg.us;

import com.hgz.optim.exception.MyException;
import com.hgz.optim.init.ApplicationInitConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/24 9:57
 */
@Slf4j
@Component
public class ConsumerHandler {

    /**
     * 处理对内消息
     *
     * @param messageExt
     */
    public void defaultHandler(MessageExt messageExt) {
        log.info("default获取到消息:tag:{},topic:{},msgId:{}", messageExt.getTags(), messageExt.getTopic(), messageExt.getMsgId());
        ConsumerService consumerService = ApplicationInitConsumer.DEFAULTMAP.get(messageExt.getTags());
        if (consumerService == null) {
            log.error("default消费者不存在,tag={}",messageExt.getTags());
            throw new MyException(9999, "消费者不存在");
        }
        String message = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        consumerService.onMessage(message);
    }

    /**
     * 处理对外消息
     *
     * @param messageExt
     */
    public void publicHandler(MessageExt messageExt) {
        log.info("public获取到消息:tag:{},topic:{},msgId:{}", messageExt.getTags(), messageExt.getTopic(), messageExt.getMsgId());
        ConsumerService consumerService = ApplicationInitConsumer.PUBLICMAP.get(messageExt.getTags());
        if (consumerService == null) {
            log.error("public消费者不存在,tag={}",messageExt.getTags());
            throw new MyException(9999, "消费者不存在");
        }
        String message = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        consumerService.onMessage(message);
    }
}
