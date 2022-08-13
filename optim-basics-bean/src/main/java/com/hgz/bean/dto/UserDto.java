package com.hgz.bean.dto;

import lombok.Data;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/12 20:06
 */
@Data
public class UserDto {

    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 姓名
     */
    private String fullname;
}
