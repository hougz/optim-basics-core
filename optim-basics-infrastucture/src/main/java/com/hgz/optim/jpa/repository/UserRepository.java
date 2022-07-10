package com.hgz.optim.jpa.repository;

import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.jpa.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 15:54
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
}
