package com.hgz.optim.annation;

import com.hgz.optim.enums.MqTopicEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * spring  Component 注解扩展注解，使用在mq消费者类上
 *
 * @author hgz
 * @version 1.0
 * @date 2022/8/7 10:25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope("singleton")
@Component
public @interface MqListener {

    @AliasFor(annotation = Component.class, attribute = "value")
    String value() default "";

    MqTopicEnum topic();

    String tags();


}
