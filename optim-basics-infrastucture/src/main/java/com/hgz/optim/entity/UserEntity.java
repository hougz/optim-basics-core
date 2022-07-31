package com.hgz.optim.entity;

import com.hgz.optim.annation.TransformAtion;
import com.hgz.optim.jackson.JacksonSensitive;
import com.hgz.optim.jackson.SensitiveStrategy;
import com.hgz.optim.service.AddressService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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

    @JacksonSensitive(strategy = SensitiveStrategy.USERNAME)
    private String userName;

    private String passWord;

    @JacksonSensitive(strategy = SensitiveStrategy.PHONE)
    private String mobile;

    private String address;

    @Transient
    @TransformAtion(from = "address", converter = AddressService.class)
    private String alias;

}
