package com.hgz.optim.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/6/11 16:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "optim_user")
@ToString(callSuper = true)
public class UserEntity extends BaseEntity implements Serializable {


    private String userName;

    private String passWord;

    private String mobile;

    private String address;

}
