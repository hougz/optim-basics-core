package com.hgz.optim.service;

import com.hgz.optim.entity.UserEntity;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/10 21:08
 */
public interface UserService {

    UserEntity findbyName(String userName);
}
