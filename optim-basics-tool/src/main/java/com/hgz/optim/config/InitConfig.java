package com.hgz.optim.config;

import com.hgz.optim.entity.User;
import com.hgz.optim.service.SendService;
import com.hgz.optim.util.BeanContexHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * springBoot 启动之后执行初始化逻辑
 *
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 19:01
 */
@Slf4j
@Component
public class InitConfig implements ApplicationRunner {

    public Map<String, SendService> map = new HashMap<>();

    /**
     * 初始化
     */
    public static final Map<String, Function<User, String>> FUNCTION_MAP = new HashMap<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, SendService> beanForType = BeanContexHolder.getBeanForType(SendService.class);
        beanForType.forEach((key, value) -> {
            if(key.equals("cbcSendServiceImpl")){
                FUNCTION_MAP.put("0",userEntity-> value.send(userEntity));
            }else{
                FUNCTION_MAP.put("1",userEntity-> value.send(userEntity));
            }
        });
    }
}
