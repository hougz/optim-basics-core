package com.hgz.bean.vo;

import com.hgz.optim.annation.HQuery;
import com.hgz.optim.vo.BaseVo;
import lombok.Data;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 15:48
 */
@Data
public class UserVo extends BaseVo {

    @HQuery(dataField = "userName")
    private String userName;

    private String passWord;

    private String mobile;

    private String address;
}
