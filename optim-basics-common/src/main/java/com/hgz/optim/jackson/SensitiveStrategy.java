package com.hgz.optim.jackson;

import lombok.Getter;

import java.util.function.Function;

/**
 * 字段脱敏
 *
 * @author hgz
 * @version 1.0
 * @date 2022/7/24 15:36
 */
public enum SensitiveStrategy {

    /**
     * 用户名
     */
    USERNAME(s -> s.replaceAll("(\\S)\\S(\\S*)", "$1*$2")),

    /**
     * 身份证
     */
    ID_CARD(s -> s.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1****$2")),


    /**
     * 手机号
     */
    PHONE(s -> s.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2")),


    /**
     * 地址
     */
    ADDRESS(s -> s.replaceAll("(\\S{3})\\S{2}(\\S*)\\S{2}", "$1****$2****"));


    @Getter
    private final Function<String, String> desensitizer;


    SensitiveStrategy(Function<String, String> desensitizer) {
        this.desensitizer = desensitizer;
    }


}
