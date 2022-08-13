package com.hgz.optim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/3/11 20:54
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {


    /**
     * 有效状态
     */
    VALUE(1, "有效状态"),

    /**
     * 无效状态
     */
    INVALUE(0, "无效状态");

    private Integer code;

    private String desc;


}
