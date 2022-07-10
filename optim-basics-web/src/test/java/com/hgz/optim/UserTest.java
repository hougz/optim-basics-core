package com.hgz.optim;

import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 16:37
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Applaction.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
      /*  UserEntity userEntity=new UserEntity();
        userEntity.setUserName("hgz");
        userEntity.setPassWord("555555");
        List<UserEntity> list = userService.list(userEntity);
        list.forEach(e->{
           log.info("数据:{}",e);
        });*/
    }
}
