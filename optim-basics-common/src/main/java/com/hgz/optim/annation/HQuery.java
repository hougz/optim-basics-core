package com.hgz.optim.annation;



import com.hgz.optim.enums.QueryOperator;

import java.lang.annotation.*;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/2 9:06
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HQuery {


    /**
     * 查询操作类型
     *
     * @return
     */
    QueryOperator operator() default QueryOperator.EQ;


    /**
     * 查询数据字段
     *
     * @return
     */
    String dataField() default "";


}
