package com.hgz.optim.controller;

import com.hgz.optim.util.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/12 20:37
 */
@Slf4j
@Api(tags = "web服务测试")
@RestController
@RequestMapping("/api/v1/web")
public class TestController {


    @GetMapping("/{code}")
    public String get(@PathVariable("code") String code) {
        log.info("参数:{}", code);
        return "Web";
    }

}
