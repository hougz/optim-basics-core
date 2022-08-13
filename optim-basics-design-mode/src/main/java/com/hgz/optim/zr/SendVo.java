package com.hgz.optim.zr;

import lombok.Data;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/31 9:27
 */
@Data
public class SendVo {

    private String sendWay;

    private String email;

    private String contact;

    private String base;


    private Integer receiveStart;

    private Integer sendStart;


}
