package com.hgz.optim.consum;


import com.hgz.optim.annation.MqListener;
import com.hgz.optim.enums.MqTopicEnum;
import com.hgz.optim.msg.us.ConsumerService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 19:17
 */
@Slf4j
@MqListener(topic = MqTopicEnum.DEFAULT, tags = "receive")
public class ConsumerReceive implements ConsumerService {

    @Override
    public void onMessage(String message) {
        log.info("接收者:{}", message);
    }
}
