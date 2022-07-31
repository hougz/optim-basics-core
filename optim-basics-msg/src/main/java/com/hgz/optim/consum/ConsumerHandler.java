package com.hgz.optim.consum;

import com.hgz.optim.consum.service.ConsumerService;
import com.hgz.optim.init.InitConsumer;
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

    public void handler(MessageExt messageExt) {
        log.info("获取到消息:tag:{},topic:{},msgId:{}", messageExt.getTags(), messageExt.getTopic(), messageExt.getMsgId());
        ConsumerService consumerService = InitConsumer.map.get(messageExt.getTags());
        String message = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        consumerService.onMessage(message);
    }
}
