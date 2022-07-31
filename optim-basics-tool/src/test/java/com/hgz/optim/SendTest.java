package com.hgz.optim;

import com.hgz.optim.config.InitConfig;
import com.hgz.optim.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.internal.Function;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/24 19:00
 */
@SpringBootTest
public class SendTest {


    @Test
    public void test() {
        User userEntity = new User();
        userEntity.setUserName("银狐");
        userEntity.setAddress("上海");
        Function<User, String> function = InitConfig.FUNCTION_MAP.get("1");
        function.apply(userEntity);
    }

}
