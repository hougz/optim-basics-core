package com.hgz.optim.controller;

import com.hgz.bean.vo.UserVo;
import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 15:47
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<UserVo, UserEntity> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }
}
