package com.hgz.optim.service.impl;

import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.jpa.repository.UserRepository;
import com.hgz.optim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/10 21:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findbyName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
