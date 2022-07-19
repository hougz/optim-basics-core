package com.hgz.optim.controller;

import com.hgz.bean.vo.EmailVo;
import com.hgz.optim.SmsFeign;
import com.hgz.optim.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/17 16:26
 */
@Api(tags = "消息发送服务")
@RestController
@RequestMapping("/api/send")
@Log4j2
public class SmsController {

    private SmsFeign smsFeign;

    public SmsController(SmsFeign smsFeign) {
        this.smsFeign = smsFeign;
    }

    /**
     * 邮件发送处理接口
     *
     * @param file    邮件附件
     * @param emailVo emailVo
     * @return
     */
    @PostMapping(value = "/email", headers = "content-type=multipart/form-data")
    public Result sendEmail(@ApiParam("邮件附件") @RequestPart("file") MultipartFile file, EmailVo emailVo) {
        smsFeign.smsSend(file, emailVo.getEmail(),emailVo.getContact(),emailVo.getTitle(),emailVo.getSubject(),emailVo.getMobile());
        return Result.success();
    }
}
