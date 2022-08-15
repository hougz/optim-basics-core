package com.hgz.optim.msg.us;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 15:58
 */
@Slf4j
@Configuration
public class RocketMqConfig {

    @Resource
    private RocketConsumeProperties rocketMqProperties;

    @Resource
    private RocketProducerProperites rocketProducerProperites;

    /**
     * 构建消费者
     * rocketmq.consumer.isOnOff 配置存在时才生效此bean
     */
    @Bean
    @ConditionalOnProperty("rocketmq.consumer.isOnOff")
    public DefaultMQPushConsumer defaultMQPushConsumer(ConsumerHandler consumerHandler) throws Exception {
        log.info("开始创建default消费者");
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
                consumerHandler.defaultHandler(messageExt);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        return consumer;
    }

    /**
     * 构建消费者
     * rocketmq.consumer.isOnOff 配置存在时才生效此bean
     */
    @Bean
    @ConditionalOnProperty("rocketmq.consumer.isOnOff")
    public DefaultMQPushConsumer publicMQPushConsumer(ConsumerHandler consumerHandler) throws Exception {
        log.info("开始创建public消费者");
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(rocketMqProperties.getGroupName());
        consumer.setNamesrvAddr(rocketMqProperties.getNamesrvAddr());
        consumer.setConsumeThreadMin(rocketMqProperties.getConsumeThreadMin());
        consumer.setConsumeThreadMax(rocketMqProperties.getConsumeThreadMax());
        consumer.setConsumerGroup(rocketMqProperties.getGroup().split(";")[1]);
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
        consumer.subscribe(rocketMqProperties.getTopics().split(";")[1], "*");
        //有序消费MessageListenerOrderly和并发消费MessageListenerConcurrently
        consumer.registerMessageListener((MessageListenerConcurrently) (messages, cintext) -> {
            for (MessageExt messageExt : messages) {
                consumerHandler.publicHandler(messageExt);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        return consumer;
    }

    /**
     * 创建生产者
     *
     * @return
     * @throws Exception
     */
    @Bean
    @ConditionalOnProperty("rocketmq.producer.isOnOff")
    public DefaultMQProducer defaultMQProducer() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(rocketProducerProperites.getGroupName());
        producer.setNamesrvAddr(rocketProducerProperites.getNamesrvAddr());
        producer.setInstanceName("producer");
        producer.start();
        return producer;
    }
}
