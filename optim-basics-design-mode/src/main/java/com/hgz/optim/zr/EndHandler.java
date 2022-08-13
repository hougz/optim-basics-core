package com.hgz.optim.zr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/31 9:35
 */
@Slf4j
@Component
public class EndHandler extends Handler {


    @Override
    public void doHandler(SendVo sendVo) {
        log.info("发送报文请求:{}", sendVo);
    }
}
