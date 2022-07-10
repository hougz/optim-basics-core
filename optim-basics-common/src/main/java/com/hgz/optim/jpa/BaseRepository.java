package com.hgz.optim.jpa;

import com.hgz.optim.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 所有对象类接口都会继承此接口 为了告诉JPA不要创建对应接口的bean对象 就在类上加注解@NoRepositoryBean
 *
 * @author hgz
 * @version 1.0
 * @date 2022/3/11 20:34
 */
@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {



}
