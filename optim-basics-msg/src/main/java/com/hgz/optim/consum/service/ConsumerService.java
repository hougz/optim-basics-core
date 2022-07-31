package com.hgz.optim.consum.service;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/23 19:13
 */
public interface ConsumerService {


    void onMessage(String message);
}
