package com.hgz.bean.vo;

import com.hgz.optim.vo.BaseVo;
import lombok.Data;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 16:10
 */
@Data
public class StudentVo extends BaseVo {

    private String name;

    private String mobile;

    private String address;
}
