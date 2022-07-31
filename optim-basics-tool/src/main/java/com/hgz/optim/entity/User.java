package com.hgz.optim.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/6/11 16:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class User extends BaseEntity implements Serializable {

    private String userName;

    private String passWord;

    private String mobile;

    private String address;

    private String alias;

}
