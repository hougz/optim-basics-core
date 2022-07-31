package com.hgz.optim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/4 20:11
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UatApplaction {

    public static void main(String[] args) {
        SpringApplication.run(UatApplaction.class, args);
    }
}
