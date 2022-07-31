package com.hgz.optim.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/22 20:57
 */
@Data
public class OptimEntity {

    private String ceratedBy;

    private LocalDateTime createdTime;

    private String updateBy;

    private LocalDateTime updateTime;
}
