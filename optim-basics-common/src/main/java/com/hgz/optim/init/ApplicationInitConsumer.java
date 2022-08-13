package com.hgz.optim.init;

import com.hgz.optim.annation.MqListener;
import com.hgz.optim.enums.MqTopicEnum;
import com.hgz.optim.msg.us.ConsumerService;
import com.hgz.optim.util.BeanContexHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目启动后做一些初始化
 *
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 19:19
 */
@Slf4j
@Component
public class ApplicationInitConsumer implements ApplicationRunner {


    public static Map<String, ConsumerService> DEFAULTMAP = new HashMap<>();

    public static Map<String, ConsumerService> PUBLICMAP = new HashMap<>();

    /**
     * 初始化所有消费者
     *
     * @param args
     */
    @Override
    public void run(ApplicationArguments args) {
        Map<String, ConsumerService> beanForType = BeanContexHolder.getBeanForType(ConsumerService.class);
        if (beanForType.size() > 0) {
            log.info("初始化consumer消费者");
        }
        beanForType.forEach((key, bean) -> {
            MqListener mqListener = bean.getClass().getAnnotation(MqListener.class);
            if (mqListener != null) {
                MqTopicEnum topic = mqListener.topic();
                String tags = mqListener.tags();
                if (MqTopicEnum.DEFAULT == topic) {
                    DEFAULTMAP.put(tags, bean);
                }
                if (MqTopicEnum.PUBLIC == topic) {
                    PUBLICMAP.put(tags, bean);
                }
            }
        });
    }
}
