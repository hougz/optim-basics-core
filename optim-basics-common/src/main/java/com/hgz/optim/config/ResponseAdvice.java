package com.hgz.optim.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgz.optim.util.Result;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

import java.util.ArrayList;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/25 20:31
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    private static final String SPRING_FOX_STR = "springfox";

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 是否支持advice功能
     * true 支持，false 不支持
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //排除拦截swagger相关
        return !methodParameter.getDeclaringClass().getName().contains(SPRING_FOX_STR);
    }

    /**
     * 对返回的数据进行处理
     */
    @Override
    @SneakyThrows
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof String) {
            return objectMapper.writeValueAsString(Result.success(o));
        }
        // 解决与统一异常处理产生的冲突问题
        if (o instanceof Result) {
            return o;
        }
        return Result.success(o);
    }
}
