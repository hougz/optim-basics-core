package com.hgz.optim.jackson;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

/**
 * 脱敏转换器
 *
 * @author hgz
 * @version 1.0
 * @date 2022/7/24 15:34
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JacksonAnnotationsInside
@JsonSerialize(using =SensitiveJsonSerializer.class)
public @interface JacksonSensitive {

    SensitiveStrategy strategy();
}
