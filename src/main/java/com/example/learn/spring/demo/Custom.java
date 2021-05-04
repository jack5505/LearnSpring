package com.example.learn.spring.demo;

import com.example.learn.spring.demo.test.SayQuote;
import com.example.learn.spring.demo.test.SayQuoteImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class Custom {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("context.xml");
        xmlApplicationContext.getBean(SayQuoteImpl.class).saySomething();
    }
}
