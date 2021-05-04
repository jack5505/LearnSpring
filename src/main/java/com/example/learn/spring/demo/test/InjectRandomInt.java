package com.example.learn.spring.demo.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min();
    int max();
}
