package com.hgz.optim.exception;

import lombok.Getter;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/6/22 20:32
 */
@Getter
public class MyException extends RuntimeException{


    private Integer errorCode;

    public MyException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
