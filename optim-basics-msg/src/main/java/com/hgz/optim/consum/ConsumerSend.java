package com.hgz.optim.consum;

import com.hgz.optim.consum.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 19:13
 */
@Component
@Slf4j
public class ConsumerSend implements ConsumerService {


    @Override
    public void onMessage(String message) {
        log.info("发送者:{}", message);
    }
}
