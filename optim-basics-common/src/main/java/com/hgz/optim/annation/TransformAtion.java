package com.hgz.optim.annation;

import com.hgz.optim.service.ConverterFieldData;

import java.lang.annotation.*;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/10 9:38
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TransformAtion {

    /**
     * 目标值转换的原始属性
     *
     * @return
     */
    String from();

    /**
     * 转换类
     *
     * @return
     */
    Class<? extends ConverterFieldData> converter();


}
