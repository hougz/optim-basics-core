package com.hgz.optim.service;

import com.alibaba.fastjson.JSON;
import com.hgz.optim.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/7 9:06
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findbyName(username);
        if (userEntity == null) {
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        String jsonString = JSON.toJSONString(userEntity);
        String[] permissionArray = new String[3];
        permissionArray[0] = "ROLE_ADMIN";
        permissionArray[1] = "ROLE_USER";
        permissionArray[2] = "ROLE_API";
        return User.withUsername(jsonString).password(userEntity.getPassword()).authorities(permissionArray).build();
    }
}
