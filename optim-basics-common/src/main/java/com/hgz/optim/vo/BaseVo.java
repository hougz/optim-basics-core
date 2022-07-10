package com.hgz.optim.vo;

import com.hgz.optim.annation.HSort;
import com.hgz.optim.enums.HSortOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 15:32
 */
@Data
public class BaseVo implements Serializable {

    private Long id;

    /*private String ceratedBy;

    private LocalDateTime createdTime;*/

    private String updateBy;

    @HSort(order = HSortOrder.ASC, priority = 100)
    private LocalDateTime updateTime;

    /**
     * 页大小
     */
    @ApiModelProperty(value = "页大小")
    private Integer pageSize = 100;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer currentPage = 1;
}
