package com.hgz.optim.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 16:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "optim_student")
public class StudentEntity extends BaseEntity {


    private String name;

    private String mobile;

    private String address;


}
