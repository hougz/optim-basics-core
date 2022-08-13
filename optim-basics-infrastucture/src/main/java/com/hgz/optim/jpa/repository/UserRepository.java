package com.hgz.optim.jpa.repository;

import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.jpa.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/10 21:03
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity> {

    UserEntity findByUsername(String userName);
}
