package com.hgz.optim.util;

import com.hgz.optim.annation.TransformAtion;
import com.hgz.optim.service.ConverterFieldData;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 字段值转换
 *
 * @author hgz
 * @version 1.0
 * @date 2022/7/10 10:21
 */
public class ConverterFieldUtil {

    /**
     * 转换数据
     *
     * @param list
     * @param <T>
     */
    public static <T> void fieldValue(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        T t = list.get(0);
        Class<?> aClass = t.getClass();
        ReflectionUtils.doWithFields(aClass, field -> {
            ReflectionUtils.makeAccessible(field);
            TransformAtion annotation = field.getAnnotation(TransformAtion.class);
            if (annotation != null) {
                Field fromField = ReflectionUtils.findField(aClass, annotation.from());
                if (fromField == null) {
                    return;
                }
                Set<String> set = collectFieldValues(list, fromField);
                if (set.isEmpty()) {
                    return;
                }
                Map<String, String> map = convertFieldValues(annotation, set);
                assignmentFieldValues(map, list, fromField, field);
            }
        });
    }

    /**
     * 获取需要转换的原始字段值的集合
     *
     * @param list
     * @param field 字段
     * @param <T>
     * @return
     */
    private static <T> Set<String> collectFieldValues(List<T> list, Field field) {
        Set<String> values = new HashSet<>();
        for (T t : list) {
            String value = (String) ReflectionUtils.getField(field, t);
            if (!StringUtils.isEmpty(value)) {
                values.add(value);
            }
        }
        return values;
    }

    /**
     * 转换字段值
     *
     * @param transformAtion
     * @param values
     * @return
     */
    private static Map<String, String> convertFieldValues(TransformAtion transformAtion, Set<String> values) {
        Class<? extends ConverterFieldData> converter = transformAtion.converter();
        ConverterFieldData dataBean = BeanContexHolder.getBean(converter);
        return dataBean.convert(values);
    }

    /**
     * 赋值给目标字段
     *
     * @param map         字段数据集
     * @param list        集合对象
     * @param fromField   源字段
     * @param targetField 目标字段
     * @param <T>
     */
    private static <T> void assignmentFieldValues(Map<String, String> map, List<T> list, Field fromField, Field targetField) {
        for (T t : list) {
            String key = (String) ReflectionUtils.getField(fromField, t);
            String value = map.get(key);
            ReflectionUtils.setField(targetField, t, value);
        }
    }
}
