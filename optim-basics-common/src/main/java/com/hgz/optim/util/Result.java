package com.hgz.optim.util;

import com.hgz.optim.enums.ResultEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/4/15 14:13
 */

/**
 * 定义统一返回结果
 *
 * @param <T>
 */
@NoArgsConstructor
@Data
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 数据体
     */
    private T data;


    public static Result success() {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }

    public static Result<?> success(Object data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static Result error(Integer code, String message) {
        return new Result(code, message);
    }


    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
