package com.hgz.optim.util;


import com.hgz.optim.annation.HSort;
import com.hgz.optim.enums.HSortOrder;
import org.springframework.data.domain.Sort;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/3 17:23
 */
public final class SortUtil {

    public static <T> Sort buildSort(T params) {
        Class<?> clazz = params.getClass();
        List<Field> fields = new ArrayList<>();
        ReflectionUtils.doWithFields(clazz, field -> {
            ReflectionUtils.makeAccessible(field);
            HSort annotation = field.getAnnotation(HSort.class);
            if (annotation == null) {
                return;
            }
            fields.add(field);
        });

        if (fields.isEmpty()) {
            return null;
        }

        fields.sort((field1, field2) -> {
            HSort sort1 = field1.getAnnotation(HSort.class);
            HSort sort2 = field2.getAnnotation(HSort.class);
            int priority1 = sort1.priority();
            int priority2 = sort2.priority();
            return priority1 - priority2;
        });

        List<Sort.Order> orders = fields.stream().map(field -> {
            HSortOrder order = field.getAnnotation(HSort.class).order();
            if (order == HSortOrder.DESC) {
                return new Sort.Order(Sort.Direction.DESC, field.getName());
            } else {
                return new Sort.Order(Sort.Direction.ASC, field.getName());
            }
        }).collect(Collectors.toList());

        return Sort.by(orders);
    }
}
