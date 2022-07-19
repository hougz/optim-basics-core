package com.hgz.optim.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/10 10:51
 */
@Service
public class AddressService implements ConverterFieldData {

    Map<String, String> map = new HashMap<>();


    @Override
    public String convert(String fieldName) {
        return null;
    }

    @Override
    public Map<String, String> convert(Set<String> values) {
        Map<String, String> mapDate = new HashMap<>();
        for (String value : values) {
            String s = map.get(value);
            mapDate.put(value, s);
        }
        return mapDate;
    }

    @PostConstruct
    public void initData() {
        map.put("北京", "帝都");
        map.put("上海", "魔都");
    }
}
