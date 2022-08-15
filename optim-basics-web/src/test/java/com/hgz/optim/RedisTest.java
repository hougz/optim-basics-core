package com.hgz.optim;

import com.alibaba.fastjson.JSON;
import com.hgz.optim.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/14 8:17
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void save() {
        User user = new User();
        user.setName("hgz");
        user.setAge("男");
        user.setAddress("上海");
        user.setBirthday("2000-03-09");
        redisTemplate.opsForValue().set("web:user", user);
    }


    @Test
    public void saveString() {
        User user = new User();
        user.setName("hgz");
        user.setAge("男");
        user.setAddress("上海");
        user.setBirthday("2000-03-09");
        stringRedisTemplate.opsForValue().set("web:userString", JSON.toJSONString(user));
    }
}
