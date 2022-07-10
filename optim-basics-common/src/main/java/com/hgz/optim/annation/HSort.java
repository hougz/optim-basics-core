package com.hgz.optim.annation;


import com.hgz.optim.enums.HSortOrder;

import java.lang.annotation.*;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/2 9:26
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HSort {

    /**
     * 排序规则
     *
     * @return
     */
    HSortOrder order() default HSortOrder.DESC;

    /**
     * 排序优先级,数字越小优先级越高
     *
     * @return
     */
    int priority();
}
