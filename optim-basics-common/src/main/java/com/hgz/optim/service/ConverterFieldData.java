package com.hgz.optim.service;

import java.util.Map;
import java.util.Set;

/**
 * 字段转换接口
 *
 * @author hgz
 * @version 1.0
 * @date 2022/7/10 9:43
 */
public interface ConverterFieldData {

    String convert(String fieldName);


    Map<String, String> convert(Set<String> values);

}
