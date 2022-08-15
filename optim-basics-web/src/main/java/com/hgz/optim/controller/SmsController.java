package com.hgz.optim.controller;

import com.hgz.bean.vo.EmailVo;
import com.hgz.optim.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 消息发送服务
 *
 * @author hgz
 * @version 1.0
 * @date 2022/8/14 17:02
 */
@Api(tags = "消息发送管理")
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class SmsController {

    /**
     * 异步发送邮件
     *
     * @param file    邮件附件
     * @param emailVo emailVo
     * @return
     */
    @ApiOperation("异步发送消息")
    @PostMapping(value = "/email", headers = "content-type=multipart/form-data")
    public Result sendEmail(@ApiParam("邮件附件") @RequestPart("file") MultipartFile file, @RequestParam("emailVo") EmailVo emailVo) {
        return Result.success();
    }


    /**
     * 同步发送接口
     *
     * @param file 邮件附件
     * @return
     */
    @ApiOperation("同步发送消息")
    @PostMapping(value = "/emails", headers = "content-type=multipart/form-data")
    public Result sendEmail(@ApiParam("邮件附件") @RequestPart("file") MultipartFile file, @RequestParam("email") String email,
                            @RequestParam("contact") String contact, @RequestParam("title") String title,
                            @RequestParam("subject") String subject, @RequestParam("mobile") String mobile) {
        return Result.success();
    }
}
