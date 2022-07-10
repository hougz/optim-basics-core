package com.hgz.optim.mapper;

import com.hgz.bean.vo.StudentVo;
import com.hgz.optim.beanmapper.BeanMapper;
import com.hgz.optim.entity.StudentEntity;
import org.mapstruct.Mapper;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 16:13
 */
@Mapper(componentModel = "spring")
public interface StudentVoToEntityMapper extends BeanMapper<StudentVo, StudentEntity> {
}
