package com.hgz.optim.controller;


import com.hgz.optim.entity.BaseEntity;
import com.hgz.optim.service.BaseService;
import com.hgz.optim.util.ConverterFieldUtil;
import com.hgz.optim.util.PageInfo;
import com.hgz.optim.util.PageUtils;
import com.hgz.optim.util.Result;
import com.hgz.optim.vo.BaseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通用的controller,封装基本的crud 操作
 *
 * @author hgz
 * @version 1.0
 * @date 2022/4/15 19:35
 */
public abstract class BaseController<V extends BaseVo, E extends BaseEntity> {

    private final BaseService<E, V> service;

    public BaseController(BaseService<E, V> service) {
        this.service = service;
    }

    @ApiOperation("新增")
    @PostMapping
    public Result<?> save(V vo) {
        service.save(vo, "system");
        return Result.success();
    }

    @ApiOperation("修改")
    @PutMapping
    public Result<?> update(V vo) {
        service.update(vo, "system");
        return Result.success();
    }

    @ApiOperation("查询")
    @GetMapping("/{id}")
    public Result<?> get(@PathVariable("id") Long id) {
        E e = service.findId(id);
        return Result.success(e);
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable("id") Long id) {
        service.delete(id, "system");
        return Result.success();
    }

    @ApiOperation("分页查询")
    @GetMapping
    public Result<?> page(V vo) {
        Page<E> page = service.page(vo.getCurrentPage(), vo.getPageSize(), vo);
        PageInfo<E> pageInfo = PageUtils.converts(page);
        ConverterFieldUtil.fieldValue(pageInfo.getRecords());
        return Result.success(pageInfo);
    }

    @ApiOperation("条件查询")
    @GetMapping("/query")
    public Result<?> list(V vo) {
        List<E> list = service.list(vo);
        ConverterFieldUtil.fieldValue(list);
        return Result.success(list);
    }

}


