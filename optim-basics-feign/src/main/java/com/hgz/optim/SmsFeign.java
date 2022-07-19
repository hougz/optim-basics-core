package com.hgz.optim;

import com.hgz.bean.vo.EmailVo;
import com.hgz.optim.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/17 16:15
 */
@FeignClient(name = "basics-sms")
public interface SmsFeign {

    @PostMapping(value = "/api/send/emails",headers = "content-type=multipart/form-data")
    Result smsSend(@RequestPart("file") MultipartFile file, @RequestParam("email") String email,
                   @RequestParam("contact") String contact,@RequestParam("title") String title,
                   @RequestParam("subject") String subject,@RequestParam("mobile") String mobile);

}
