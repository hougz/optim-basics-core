package com.hgz.optim.controller;

import com.alibaba.fastjson.JSON;
import com.hgz.bean.vo.EmailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/8/12 20:37
 */
@Slf4j
@Api(tags = "web服务测试")
@RestController
@RequestMapping("/web")
public class TestController {


    @GetMapping("/{code}")
    public String get(@PathVariable("code") String code) {
        log.info("参数:{}", code);
        return "Web";
    }

    @GetMapping
    public String get(@Valid EmailVo emailVo) {
        log.info("参数:{}", JSON.toJSONString(emailVo));
        return "Web";
    }

    @ApiOperation("获取图片")
    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image() throws IOException {
        File file = new File("D:\\图片\\1.jpg");
        return FileUtils.readFileToByteArray(file);
    }


}
