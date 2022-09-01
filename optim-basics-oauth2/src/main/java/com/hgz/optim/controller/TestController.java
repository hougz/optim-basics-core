package com.hgz.optim.controller;

import com.hgz.optim.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/11 20:00
 */
@RestController
@Api(tags = "测试")
@RequestMapping("/api/v1/test")
@Slf4j
public class TestController {

    @ApiOperation("查询")
    @GetMapping
    public Result get() {
        log.info("获取请求");
        return Result.success();
    }
}
