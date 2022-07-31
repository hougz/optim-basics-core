package com.hgz.optim.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/3 15:56
 */
@Component
public class BeanContexHolder implements ApplicationContextAware {

    private static ApplicationContext context; //应用上下文环境

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 根据bean name 获取对象
     *
     * @param name
     * @return
     */
    public static <T> T getBean(String name) {
        return (T) context.getBean(name);
    }

    /**
     * 根据Class获取对象
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return context.getBean(clazz);
    }

    /**
     * 根据Class获取对象
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String beanName, Class<T> clazz) throws BeansException {
        return context.getBean(beanName, clazz);
    }

    public static <T> Map<String, T> getBeanForType(Class<T> beanClass) {
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        return factory.getBeansOfType(beanClass);
    }


}
