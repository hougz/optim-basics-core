package com.hgz.optim.config;

import com.hgz.optim.consum.ConsumerHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 15:58
 */
@Slf4j
@Configuration
public class RocketMqConfig {

    @Resource
    private RocketMqProperties rocketMqProperties;

    /**
     * 构建消费者
     */
    @Bean
    /*@ConditionalOnProperty(prefix = "rocketmq.consumer", value = "isOnOff", havingValue = "on")*/
    public DefaultMQPushConsumer defaultMQPushConsumer(ConsumerHandler consumerHandler) throws Exception {
        log.info("开始创建消费者");
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(rocketMqProperties.getGroupName());
        consumer.setNamesrvAddr(rocketMqProperties.getNamesrvAddr());
        consumer.setConsumeThreadMin(rocketMqProperties.getConsumeThreadMin());
        consumer.setConsumeThreadMax(rocketMqProperties.getConsumeThreadMax());
        consumer.setConsumerGroup(rocketMqProperties.getGroup().split(";")[0]);
        /**
         * 设置consumer第一次启动是从队列头部开始还是队列尾部开始
         * 如果不是第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        /**
         * 设置消费模型，集群还是广播，默认为集群
         *
         */
        /*consumer.setMessageModel(MessageModel.CLUSTERING);*/
        consumer.subscribe(rocketMqProperties.getTopics().split(";")[0], "*");
        //有序消费MessageListenerOrderly和并发消费MessageListenerConcurrently
        consumer.registerMessageListener((MessageListenerConcurrently) (messages, cintext) -> {
            for (MessageExt messageExt : messages) {
                consumerHandler.handler(messageExt);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        return consumer;
    }
}
