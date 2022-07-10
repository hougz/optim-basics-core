package com.hgz.optim.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 标注为@MappedSuperclass的类将不是一个完整的实体类，他将不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中
 *
 * @author hgz
 * @version 1.0
 * @date 2022/3/11 20:20
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    //指定id生成策略为自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ceratedBy;

    private LocalDateTime createdTime;

    private String updateBy;

    private LocalDateTime updateTime;

}
