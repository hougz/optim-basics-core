package com.hgz.optim.entity;

import lombok.Data;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/21 20:17
 */
@Data
public class UserEntity {

    private Long id;

    private String userName;

    private String passWord;

    private String mobile;

    private String address;

    private String status;

    private String createBy;
}
