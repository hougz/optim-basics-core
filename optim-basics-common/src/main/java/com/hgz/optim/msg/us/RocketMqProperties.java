package com.hgz.optim.msg.us;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 16:50
 */
@Component
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "rocketmq.consumer")
public class RocketMqProperties {

    private String groupName;

    private String namesrvAddr;

    private String topics;

    private String group;

    // 消费者线程数
    private Integer consumeThreadMin;

    private Integer consumeThreadMax;

}
