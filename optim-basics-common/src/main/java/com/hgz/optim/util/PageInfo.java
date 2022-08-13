package com.hgz.optim.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 统一分页类
 *
 * @author hgz
 * @version 1.0
 * @date 2022/3/12 9:25
 */
@Data
@NoArgsConstructor
public class PageInfo<T> {


    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 总记录数
     */
    private Long totalRecords;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 数据集
     */
    private List<T> records;


}
