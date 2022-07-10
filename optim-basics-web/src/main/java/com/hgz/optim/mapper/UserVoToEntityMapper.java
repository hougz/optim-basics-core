package com.hgz.optim.mapper;

import com.hgz.bean.vo.UserVo;
import com.hgz.optim.beanmapper.BeanMapper;
import com.hgz.optim.entity.UserEntity;
import org.mapstruct.Mapper;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 15:59
 */
@Mapper(componentModel = "spring")
public interface UserVoToEntityMapper extends BeanMapper<UserVo, UserEntity> {
}
