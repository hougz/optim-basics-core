package com.hgz.optim;

import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.jpa.repository.UserRepository;
import com.hgz.optim.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/10 21:05
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test() {
        UserEntity userEntity = new UserEntity();
        userEntity.setMobile("18039317141");
        userEntity.setStatus("1");
        userEntity.setPassword("$2a$10$ScQYOC9vHTb8R8aRB9Vya.tcOIJIo1jr9XubQVSNa83dT4DPWGwtm");
        userEntity.setUsername("hgz");
        userEntity.setCeratedBy("system");
        userEntity.setCreatedTime(LocalDateTime.now());
        userEntity.setUpdateBy("system");
        userEntity.setUpdateTime(LocalDateTime.now());
        userRepository.save(userEntity);
    }

    @Test
    public void password() {
       /* String hashpw = BCrypt.hashpw("hgz2022", BCrypt.gensalt());
        System.out.println(hashpw);

        //校验密码
        boolean checkpw = BCrypt.checkpw("secret", "$2a$10$pXvNwBLjfC..OVBtaBn.H.QpAdabDF8At3YUYa8voxWFKRlokSdKS");
        boolean checkpw2 = BCrypt.checkpw("123", "$2a$10$HuClcUqr/FSLmzSsp9SHqe7D51Keu1sAL7tUAAcb..FyILiLdFKYy");
        System.out.println(checkpw);
        System.out.println(checkpw2);*/
        String encode = passwordEncoder.encode("hgz2022");
        System.out.println(encode);
    }

}
