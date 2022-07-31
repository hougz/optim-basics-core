package com.hgz.optim.dao;

import com.hgz.optim.entity.OptimUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/22 21:06
 */
@Mapper
public interface OptimUserDao {

    Long insert(OptimUser optimUser);

    Long insertList(List<OptimUser> list);

    int update(OptimUser optimUser);
}
