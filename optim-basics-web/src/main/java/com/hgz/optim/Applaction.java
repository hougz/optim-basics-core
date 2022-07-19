package com.hgz.optim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/4 20:11
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class Applaction {

    public static void main(String[] args) {
        SpringApplication.run(Applaction.class, args);
    }
}
