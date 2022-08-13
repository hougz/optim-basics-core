package com.hgz.optim.zr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/31 9:26
 */
@Slf4j
@Component
public class Receive extends Handler{


    @Override
    public void doHandler(SendVo sendVo) {
        log.info("接收到发送请求:{}",sendVo);
        sendVo.setReceiveStart(1);
        handler.doHandler(sendVo);
    }
}
