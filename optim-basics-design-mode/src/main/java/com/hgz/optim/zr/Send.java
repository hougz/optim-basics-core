package com.hgz.optim.zr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/31 9:30
 */
@Slf4j
@Component
public class Send extends Handler {

    @Override
    public void doHandler(SendVo sendVo) {
        log.info("组装发送报文:{}", sendVo);
        sendVo.setSendStart(1);
        handler.doHandler(sendVo);
    }
}
