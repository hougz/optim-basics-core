package com.hgz.optim.mapper;

import com.hgz.bean.vo.UserVo;
import com.hgz.optim.entity.UserEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-09T17:36:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class UserVoToEntityMapperImpl implements UserVoToEntityMapper {

    @Override
    public UserEntity mapper(UserVo t) {
        if ( t == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( t.getId() );
        userEntity.setUpdateBy( t.getUpdateBy() );
        userEntity.setUpdateTime( t.getUpdateTime() );
        userEntity.setUserName( t.getUserName() );
        userEntity.setPassWord( t.getPassWord() );
        userEntity.setMobile( t.getMobile() );
        userEntity.setAddress( t.getAddress() );

        return userEntity;
    }

    @Override
    public UserVo mapperReverse(UserEntity k) {
        if ( k == null ) {
            return null;
        }

        UserVo userVo = new UserVo();

        userVo.setId( k.getId() );
        userVo.setUpdateBy( k.getUpdateBy() );
        userVo.setUpdateTime( k.getUpdateTime() );
        userVo.setUserName( k.getUserName() );
        userVo.setPassWord( k.getPassWord() );
        userVo.setMobile( k.getMobile() );
        userVo.setAddress( k.getAddress() );

        return userVo;
    }

    @Override
    public void mapper(UserVo arg0, UserEntity arg1) {
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
        if ( arg0.getUserName() != null ) {
            arg1.setUserName( arg0.getUserName() );
        }
        if ( arg0.getPassWord() != null ) {
            arg1.setPassWord( arg0.getPassWord() );
        }
        if ( arg0.getMobile() != null ) {
            arg1.setMobile( arg0.getMobile() );
        }
        if ( arg0.getAddress() != null ) {
            arg1.setAddress( arg0.getAddress() );
        }
    }

    @Override
    public void mapperReverse(UserEntity arg0, UserVo arg1) {
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
        if ( arg0.getUserName() != null ) {
            arg1.setUserName( arg0.getUserName() );
        }
        if ( arg0.getPassWord() != null ) {
            arg1.setPassWord( arg0.getPassWord() );
        }
        if ( arg0.getMobile() != null ) {
            arg1.setMobile( arg0.getMobile() );
        }
        if ( arg0.getAddress() != null ) {
            arg1.setAddress( arg0.getAddress() );
        }
    }
}
