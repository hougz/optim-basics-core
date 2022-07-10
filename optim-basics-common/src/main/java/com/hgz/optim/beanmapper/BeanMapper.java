package com.hgz.optim.beanmapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/3/29 16:19
 */
public interface BeanMapper<T,K> {

    K mapper(T t);

    T mapperReverse(K k);

    default List<K> batchMapper(List<T> t){
        return t==null?null:t.stream().map(this::mapper).collect(Collectors.toList());
    }

    default List<T> batchMapperReverse(List<K> k){
        return k==null?null:k.stream().map(this::mapperReverse).collect(Collectors.toList());
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapper(T t, @MappingTarget K k);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapperReverse(K k, @MappingTarget T t);
}
