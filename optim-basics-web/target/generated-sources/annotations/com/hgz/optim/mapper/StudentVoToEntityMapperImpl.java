package com.hgz.optim.mapper;

import com.hgz.bean.vo.StudentVo;
import com.hgz.optim.entity.StudentEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-17T21:10:21+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class StudentVoToEntityMapperImpl implements StudentVoToEntityMapper {

    @Override
    public StudentEntity mapper(StudentVo t) {
        if ( t == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId( t.getId() );
        studentEntity.setUpdateBy( t.getUpdateBy() );
        studentEntity.setUpdateTime( t.getUpdateTime() );
        studentEntity.setName( t.getName() );
        studentEntity.setMobile( t.getMobile() );
        studentEntity.setAddress( t.getAddress() );

        return studentEntity;
    }

    @Override
    public StudentVo mapperReverse(StudentEntity k) {
        if ( k == null ) {
            return null;
        }

        StudentVo studentVo = new StudentVo();

        studentVo.setId( k.getId() );
        studentVo.setUpdateBy( k.getUpdateBy() );
        studentVo.setUpdateTime( k.getUpdateTime() );
        studentVo.setName( k.getName() );
        studentVo.setMobile( k.getMobile() );
        studentVo.setAddress( k.getAddress() );

        return studentVo;
    }

    @Override
    public void mapper(StudentVo arg0, StudentEntity arg1) {
        if ( arg0 == null ) {
            return;
        }

        if ( arg0.getId() != null ) {
            arg1.setId( arg0.getId() );
        }
        if ( arg0.getUpdateBy() != null ) {
            arg1.setUpdateBy( arg0.getUpdateBy() );
        }
        if ( arg0.getUpdateTime() != null ) {
            arg1.setUpdateTime( arg0.getUpdateTime() );
        }
        if ( arg0.getName() != null ) {
            arg1.setName( arg0.getName() );
        }
        if ( arg0.getMobile() != null ) {
            arg1.setMobile( arg0.getMobile() );
        }
        if ( arg0.getAddress() != null ) {
            arg1.setAddress( arg0.getAddress() );
        }
    }

    @Override
    public void mapperReverse(StudentEntity arg0, StudentVo arg1) {
        if ( arg0 == null ) {
            return;
        }

        if ( arg0.getId() != null ) {
            arg1.setId( arg0.getId() );
        }
        if ( arg0.getUpdateBy() != null ) {
            arg1.setUpdateBy( arg0.getUpdateBy() );
        }
        if ( arg0.getUpdateTime() != null ) {
            arg1.setUpdateTime( arg0.getUpdateTime() );
        }
        if ( arg0.getName() != null ) {
            arg1.setName( arg0.getName() );
        }
        if ( arg0.getMobile() != null ) {
            arg1.setMobile( arg0.getMobile() );
        }
        if ( arg0.getAddress() != null ) {
            arg1.setAddress( arg0.getAddress() );
        }
    }
}
