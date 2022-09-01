package com.hgz.optim.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * 用戶信息表
 *
 * @author hgz
 * @version 1.0
 * @date 2022/8/10 20:58
 */
@Data
@Entity(name = "h_user")
public class UserEntity extends BaseEntity {

    private String username;

    private String password;

    private String mobile;

    private String status;

}
