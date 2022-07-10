package com.hgz.optim.service;


import com.hgz.optim.beanmapper.BeanMapper;
import com.hgz.optim.entity.BaseEntity;
import com.hgz.optim.jpa.BaseRepository;
import com.hgz.optim.util.SortUtil;
import com.hgz.optim.util.SpecificationUtil;
import com.hgz.optim.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/3/11 20:38
 */
public abstract class BaseService<E extends BaseEntity, V extends BaseVo> {

    @Autowired
    private BaseRepository<E> repository;

    @Autowired
    private BeanMapper<V, E> mapper;

    /**
     * 保存方法
     *
     * @param vo
     * @param userCode
     * @return
     */
    public E save(V vo, String userCode) {
        E entity = this.mapper.mapper(vo);
        LocalDateTime time = LocalDateTime.now();
        entity.setCeratedBy(userCode);
        entity.setCreatedTime(time);
        entity.setUpdateBy(userCode);
        entity.setUpdateTime(time);
        return repository.save(entity);
    }

    /**
     * 修改操作
     *
     * @param vo
     * @param userCode
     */
    public void update(V vo, String userCode) {
        E entity = this.mapper.mapper(vo);
        LocalDateTime time = LocalDateTime.now();
        entity.setUpdateBy(userCode);
        entity.setUpdateTime(time);
        repository.save(entity);
    }

    /**
     * 删除操作
     *
     * @param id
     * @param userCode
     */
    public void delete(Long id, String userCode) {
        Optional<E> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            E e = optional.get();
            LocalDateTime time = LocalDateTime.now();
            e.setUpdateBy(userCode);
            e.setUpdateTime(time);
            repository.save(e);
        }
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public E findId(Long id) {
        Optional<E> optiona = this.repository.findById(id);
        if (optiona.isPresent()) {
            return optiona.get();
        } else {
            return null;
        }
    }

    /**
     * 条件查询
     *
     * @param e
     * @return
     */
    public List<E> findAll(E e) {
        Example<E> example = Example.of(e);
        Sort sort = Sort.by(Sort.Direction.DESC, "updateTime");
        return repository.findAll(example, sort);
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @param vo
     * @return
     */
    public Page<E> page(Integer currentPage, Integer pageSize, V vo) {
        E e = this.mapper.mapper(vo);
        Example<E> example = Example.of(e);
        PageRequest pageRequest = getPageRequest(currentPage, pageSize);
        return repository.findAll(example, pageRequest);
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @param specification
     * @return
     */
    public Page<E> page(Integer currentPage, Integer pageSize, Specification specification) {
        PageRequest pageRequest = getPageRequest(currentPage, pageSize);
        return repository.findAll(specification, pageRequest);
    }

    private PageRequest getPageRequest(Integer currentPage, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateTime");
        return PageRequest.of(currentPage - 1, pageSize, sort);
    }


    /**
     * 条件查询
     *
     * @param vo
     * @return
     */
    public List<E> list(V vo) {
        Specification<E> specification = SpecificationUtil.build(vo.getClass(), vo);
        Sort sort = SortUtil.buildSort(vo);
        return repository.findAll(specification, sort);
    }

}
