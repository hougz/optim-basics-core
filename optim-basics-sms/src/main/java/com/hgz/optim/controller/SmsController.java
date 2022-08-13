package com.hgz.optim.controller;

import com.hgz.bean.vo.EmailVo;
import com.hgz.optim.service.SmsService;
import com.hgz.optim.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/16 17:17
 */
@Api(tags = "消息发送服务")
@RestController
@RequestMapping("/api/v1/sms")
@Log4j2
public class SmsController {

    private SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    /**
     * 统一邮件发送处理接口
     *
     * @param file    邮件附件
     * @param emailVo emailVo
     * @return
     */
    @PostMapping(value = "/email", headers = "content-type=multipart/form-data")
    public Result sendEmail(@ApiParam("邮件附件") @RequestPart("file") MultipartFile file,@RequestParam("emailVo") EmailVo emailVo) {
        smsService.sendEmail(emailVo, file);
        return Result.success();
    }


    /**
     * 统一邮件发送处理接口
     *
     * @param file 邮件附件
     * @return
     */
    @PostMapping(value = "/emails", headers = "content-type=multipart/form-data")
    public Result sendEmail(@ApiParam("邮件附件") @RequestPart("file") MultipartFile file, @RequestParam("email") String email,
                            @RequestParam("contact") String contact, @RequestParam("title") String title,
                            @RequestParam("subject") String subject, @RequestParam("mobile") String mobile) {
        EmailVo emailVo=new EmailVo();
        emailVo.setContact(contact);
        emailVo.setEmail(email);
        emailVo.setSubject(subject);
        emailVo.setTitle(title);
        smsService.sendEmail(emailVo, file);
        return Result.success();
    }

}
