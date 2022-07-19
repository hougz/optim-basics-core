package com.hgz.bean.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/16 17:21
 */
@Data
public class EmailVo implements Serializable {


    /**
     * 收件人邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确!")
    private String email;

    /**
     * 邮件内容
     */
    @NotNull(message = "内容不能为空")
    private String contact;

    /**
     * 抄送人
     */
    private String cc;

    @NotBlank(message = "标题不能为空")
    @Length(max = 20, message = "标题不能超过20个字符")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "标题限制：最多20字符，包含文字、字母和数字")
    private String title;

    /**
     * 邮件主题
     */
    private String subject;


    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String mobile;

}
