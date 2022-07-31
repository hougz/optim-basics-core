package com.hgz.optim.controller;

import com.hgz.bean.vo.UserVo;
import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.service.UserService;
import com.hgz.optim.util.Result;
import com.hgz.optim.util.RocketMqProducerUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final RocketMqProducerUtil rocketMqProducerUtil;

    public UserController(UserService userService, RocketMqProducerUtil rocketMqProducerUtil) {
        super(userService);
        this.userService = userService;
        this.rocketMqProducerUtil = rocketMqProducerUtil;
    }

    @ApiOperation("消息推送至mq服务")
    @GetMapping("/send_sms")
    public Result sendSms() {
        UserEntity userEntity = userService.findId(1L);
        rocketMqProducerUtil.sendAsync("topic%basics%msg%default", "send", "4884659896566885526", userEntity);
        return Result.success();
    }


    /*  {
          "code": 200,
              "message": "success",
              "data": null
      }*/
    @ApiOperation("测试")
    @GetMapping("/test")
    public void querTest() {

    }
}
