package com.hgz.optim.zr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/31 9:42
 */
@Component
public class DoHandler {

    @Autowired
    private Receive receive;

    @Autowired
    private Send send;

    @Autowired
    private EndHandler endHandler;

    /**
     * 构建责任链
     *
     * @param sendVo
     */
    public void doHandler(SendVo sendVo) {
        Handler.Builder builder = new Handler.Builder();
        builder.addBuilder(receive)
                .addBuilder(send)
                .addBuilder(endHandler);
        builder.build().doHandler(sendVo);
    }
}
