package com.hgz.optim.util;


import com.hgz.optim.annation.HQuery;
import com.hgz.optim.enums.QueryOperator;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/3 16:43
 */
public class SpecificationUtil {

    public static <T, V> Specification<T> build(Class<?> clazz, V params) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            ReflectionUtils.doWithFields(clazz, field -> {
                //不是条件字段

                ReflectionUtils.makeAccessible(field);
                //字段值为null或者""，直接返回
                Object value = ReflectionUtils.getField(field, params);
                if (value == null || (field.getType() == String.class && "".equals(value))) return;

                HQuery hQuery = field.getAnnotation(HQuery.class);
                String searchName;
                QueryOperator searchOperator;
                if (hQuery != null) {
                    searchName = hQuery.dataField();
                    searchOperator = hQuery.operator();
                } else {
                    return;
                }

                if (searchOperator == QueryOperator.EQ) {
                    predicates.add(builder.equal(root.get(searchName), value));
                } else if (searchOperator == QueryOperator.GQ) {
                    predicates.add(builder.greaterThanOrEqualTo(root.get(searchName).as(LocalDateTime.class), (LocalDateTime) value));
                } else if (searchOperator == QueryOperator.LQ) {
                    predicates.add(builder.lessThanOrEqualTo(root.get(searchName).as(LocalDateTime.class), (LocalDateTime) value));
                } else if (searchOperator == QueryOperator.IN) {
                    predicates.add(builder.in(root.get(searchName).in(value)));
                } else if (searchOperator == QueryOperator.LIKE) {
                    predicates.add(builder.like(root.get(searchName).as(String.class), "%" + value + "%"));
                }
            });
            Predicate[] arr = new Predicate[predicates.size()];
            predicates.toArray(arr);
            return query.where(arr).getRestriction();
        };
    }
}
