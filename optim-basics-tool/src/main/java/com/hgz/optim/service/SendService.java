package com.hgz.optim.service;

import com.hgz.optim.entity.User;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 10:43
 */
public interface SendService {


    void send();


    String send(User userEntity);

}
