package com.hgz.optim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/4 20:11
 */
/*@EntityScan("com.hgz.optim.jpa")
@ComponentScan(value="com.hgz.optim")
@EnableJpaRepositories(basePackages = "com.hgz.optim.jpa")*/
@SpringBootApplication
public class Applaction {

    public static void main(String[] args) {
        SpringApplication.run(Applaction.class, args);
    }
}
