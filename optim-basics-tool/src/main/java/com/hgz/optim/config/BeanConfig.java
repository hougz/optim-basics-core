package com.hgz.optim.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 10:44
 */
@Configuration
public class BeanConfig {

    /*@Bean
    public UserService getBean() {
        return new UserService();
    }

    @Bean
    @ConditionalOnMissingBean(UserService.class)   //没有此注解的bean生效
    public UserService userService() {
        return new UserService();
    }*/
}
