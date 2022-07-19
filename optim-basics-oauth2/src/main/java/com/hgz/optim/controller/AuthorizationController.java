package com.hgz.optim.controller;

import com.hgz.optim.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/13 20:49
 */
@Log4j2
@Api(tags = "认证授权")
@RequestMapping("/oauth")
@RestController
public class AuthorizationController {


    @GetMapping
    @ApiOperation("获取令牌")
    public Result oauth() {
        return Result.success();
    }
}
