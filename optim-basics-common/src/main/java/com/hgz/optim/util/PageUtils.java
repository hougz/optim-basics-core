package com.hgz.optim.util;

import org.springframework.data.domain.Page;

/**
 * 分页转换工具类
 *
 * @author hgz
 * @version 1.0
 * @date 2022/3/12 9:25
 */
public class PageUtils {

    /**
     * jpa分页转换
     *
     * @param page
     * @param <T>
     * @return
     */
    public static <T> PageInfo<T> converts(Page<T> page) {
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(page.getSize());
        pageInfo.setCurrentPage(page.getNumber() + 1);//jpa页码从0开始
        pageInfo.setTotalPages(page.getTotalPages());
        pageInfo.setTotalRecords(page.getTotalElements());
        pageInfo.setRecords(page.getContent());
        return pageInfo;
    }
}
