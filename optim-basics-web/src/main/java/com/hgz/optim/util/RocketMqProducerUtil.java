package com.hgz.optim.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/24 11:02
 */
@Component
@Slf4j
public class RocketMqProducerUtil {

    private final DefaultMQProducer defaultMQProducer;

    public RocketMqProducerUtil(DefaultMQProducer defaultMQProducer) {
        this.defaultMQProducer = defaultMQProducer;
    }

    /**
     * 发送同步消息
     *
     * @param topic
     * @param tag
     * @param key
     * @param data
     * @param <T>
     */
    public <T> void send(String topic, String tag, String key, T data) {
        try {
            Message message = new Message(topic, tag, key, JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8));
            log.info("发送Mq消息topic:{},tag:{},key:{},msg:{}", topic, tag, key, message);
            SendResult send = defaultMQProducer.send(message);
            log.info("发送Mq消息结果key:{}", JSON.toJSONString(send));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送异步消息
     *
     * @param topic
     * @param tag
     * @param key
     * @param data
     * @param <T>
     */
    public <T> void sendAsync(String topic, String tag, String key, T data) {
        try {
            Message message = new Message(topic, tag, key, JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8));
            log.info("发送Mq消息topic:{},tag:{},key:{},msg:{}", topic, tag, key, message);
            defaultMQProducer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("key:{}发送Mq消息结果:{}", key, JSON.toJSONString(sendResult));
                }

                @Override
                public void onException(Throwable e) {
                    log.info("key:{}发送Mq消息失败", key, e);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 延迟发送消息
     *
     * @param topic
     * @param tag
     * @param key
     * @param data
     * @param <T>
     */
    public <T> void sendDelayTimeLevel(String topic, String tag, String key, T data) {
        try {
            Message message = new Message(topic, tag, key, JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8));
            //设置延迟时间,时间长度为(1s/5s/10s/30s/1m/2m/3m/4m/5m/6m/7m/8m/9m/10m/20m/30m/1h/2h)
            //设置5 表示延迟1分钟
            message.setDelayTimeLevel(5);
            log.info("发送Mq消息topic:{},tag:{},key:{},msg:{}", topic, tag, key, message);
            defaultMQProducer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("key:{}发送Mq消息结果:{}", key, JSON.toJSONString(sendResult));
                }

                @Override
                public void onException(Throwable e) {
                    log.info("key:{}发送Mq消息失败", key, e);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
