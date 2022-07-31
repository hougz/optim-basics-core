package com.hgz.optim.init;

import com.hgz.optim.consum.service.ConsumerService;
import com.hgz.optim.util.BeanContexHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 19:19
 */
@Slf4j
@Component
public class InitConsumer implements ApplicationRunner {

    public static Map<String, ConsumerService> map = new HashMap<>();

    @Override
    public void run(ApplicationArguments args) {
        log.info("初始化consumer消费者");
        Map<String, ConsumerService> beanForType = BeanContexHolder.getBeanForType(ConsumerService.class);
        beanForType.forEach((key, value) -> {
            log.info("key:{},value:{}", key, value);
            if (key.equals("consumerSend")) {
                map.put("send", value);
            } else {
                map.put("receive", value);
            }
        });
    }
}
