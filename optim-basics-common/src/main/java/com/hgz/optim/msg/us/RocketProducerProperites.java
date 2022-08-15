package com.hgz.optim.msg.us;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/14 17:32
 */
@Component
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "rocketmq.producer")
public class RocketProducerProperites {


    private String groupName;


    private String namesrvAddr;
}
