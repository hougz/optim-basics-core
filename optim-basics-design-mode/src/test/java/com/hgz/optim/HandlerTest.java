package com.hgz.optim;

import com.hgz.optim.zr.DoHandler;
import com.hgz.optim.zr.SendVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/31 9:46
 */
@SpringBootTest
public class HandlerTest {

    @Autowired
    private DoHandler doHandler;


    @Test
    public void test(){
        SendVo sendVo=new SendVo();
        doHandler.doHandler(sendVo);
    }
}
