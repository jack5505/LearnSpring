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
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("context.xml");
        // xmlApplicationContext.getBeanDefinitionNames() all name of Beans in debug mode can see
        while (true){
            Thread.sleep(100);
            xmlApplicationContext.getBean(SayQuoteImpl.class).saySomething();
        }
    }
}
