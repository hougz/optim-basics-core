package com.hgz.optim.service;

import com.hgz.bean.vo.EmailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/16 17:26
 */
@Slf4j
@Service
public class SmsService {

    /**
     * 发件箱地址
     */
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    /**
     * 发送邮件
     *
     * @param emailVo
     * @return
     */
    public void sendEmail(EmailVo emailVo,MultipartFile file) {
        File tempFile = null;
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(emailVo.getEmail());
            //主题
            helper.setSubject("【" + emailVo.getSubject() + "-" + LocalDate.now() + " " + LocalTime.now().withNano(0) + "】");
            if (file != null) {
                //添加附件
                tempFile = File.createTempFile("email", file.getOriginalFilename());
                file.transferTo(tempFile);
                FileSystemResource file1 = new FileSystemResource(tempFile);
                helper.addAttachment(file.getOriginalFilename(), file1);
            }
            //调用模板
            /*Map<String, Object> model = new HashMap<>();
            model.put("params", object);
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            String string = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);*/
            //邮件内容
            helper.setText(emailVo.getContact(), true);
            //发送邮件
            mailSender.send(mimeMessage);
            log.info("发送邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (tempFile != null) {
                    tempFile.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
