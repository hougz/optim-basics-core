package com.hgz.optim.exception;

import com.hgz.optim.util.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * 全局统一异常处理类
 *
 * @author hgz
 * @version 1.0
 * @date 2022/6/22 20:29
 */
@Log4j2
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 处理参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream().map(err -> {
            return err.getField() + err.getDefaultMessage();
        }).collect(Collectors.joining(";"));
        log.info("参数:{}", message);
        return Result.error(999, message);
    }

    /**
     * 处理自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public Result myException(MyException e) {
        log.error("自定义异常: ", e);
        return Result.error(e.getErrorCode(), e.getMessage());
    }


    /**
     * 拦截抛出的异常，@ResponseStatus：用来改变响应状态码
     * @param e
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result handlerThrowable(Throwable e, HttpServletRequest request) {
        log.error("发生未知异常！原因是: ", e);
        return Result.error(500, e.toString());
    }

}
