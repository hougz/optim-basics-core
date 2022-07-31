package com.hgz.optim.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/24 10:38
 */
@Configuration
public class ProducerConfig {

    /**
     * 创建生产者
     *
     * @return
     * @throws Exception
     */
    @Bean
    public DefaultMQProducer defaultMQProducer() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("producer%basics%default");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("producer");
        producer.start();
        return producer;
    }
}
