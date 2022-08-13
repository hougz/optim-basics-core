package com.hgz.optim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/4/15 15:09
 */
@Getter
@AllArgsConstructor
@ToString
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(200, "success"),

    /**
     * 失败
     */
    ERROR(500, "服务端异常"),

    /**
     * session不存在或已失效
     */
    SESSION_ERROR(500200, "session不存在或已失效"),

    /**
     * 用户名或密码错误
     */
    LOGINVO_ERROR(500201, "用户名或密码错误");


    private final Integer code;

    private final String message;
}
