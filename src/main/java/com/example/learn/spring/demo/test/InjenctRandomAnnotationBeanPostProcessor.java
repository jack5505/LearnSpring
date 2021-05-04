package com.example.learn.spring.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class InjenctRandomAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            InjectRandomInt injectRandomInt =  fields[i].getAnnotation(InjectRandomInt.class);
            if (injectRandomInt != null){
                int min = injectRandomInt.min();
                int max = injectRandomInt.max();
                Random random = new Random();
                int var = min  + random.nextInt(max - min);
                fields[i].setAccessible(true);
                ReflectionUtils.setField(fields[i],bean,var);
            }

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
