package com.hgz.optim.entity;

import lombok.Data;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/22 20:52
 */
@Data
public class OptimUser extends OptimEntity {

    private Long id;

    private String userName;

    private String passWord;

    private String mobile;

    private String address;

}
