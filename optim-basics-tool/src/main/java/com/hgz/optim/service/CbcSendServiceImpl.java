package com.hgz.optim.service;

import com.hgz.optim.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 18:52
 */
@Slf4j
@Service
public class CbcSendServiceImpl implements SendService {


    @Override
    public void send() {
        log.info("CBD发送开始");
    }


    @Override
    public String send(User userEntity) {
        log.info("CBD发送开始:{}",userEntity.toString());
        return null;
    }
}
