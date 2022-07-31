package com.hgz.optim.dao;

import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/21 20:21
 */
@Mapper
public interface UserDao {


    UserEntity selectById(Long id);

    List<UserEntity> getList(String name);

    /**
     * 查询  @Param
     *
     * @param userName
     * @param passWord
     * @return
     */
    List<UserEntity> get(@Param("userName") String userName, @Param("passWord") String passWord);


    /**
     * 统计数据个数
     *
     * @return
     */
    Long count();


    List<UserEntity> select(UserEntity userEntity);


    List<UserEntity> selectLike(@Param("userName") String userName, @Param("passWord") String passWord);

    /**
     * <where></where>
     * where元素主要用来简化SQL语句中的where条件判断，并智能的处理and和or，不必担心多余关键字导致的语法错误
     *
     * @param userName
     * @param passWord
     * @return
     */
    List<UserEntity> selectList(@Param("userName") String userName, @Param("passWord") String passWord);


    List<UserEntity> selectEntity(UserEntity userEntity);


    List<UserEntity> selectEntity2(UserVo userVo);


    /**
     * 使用in
     * @param ids
     * @return
     */
    List<UserEntity> selectIn(List<Long> ids);


    /**
     * 使用in
     * @param mobiles
     * @return
     */
    List<UserEntity> selectMobileIn(List<String> mobiles);
}
