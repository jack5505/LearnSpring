package com.example.learn.spring.demo.test;

import javax.annotation.PostConstruct;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Profiling
public class SayQuoteImpl implements SayQuote {

    @InjectRandomInt(min = 1, max = 10)
    public int repeat;


    @PostConstruct
    public void init(){
        System.out.println("Phase 1");
        System.out.println(repeat);
    }

    public SayQuoteImpl() {
        System.out.println(repeat);
    }

    private String name;

    @Override
    public void saySomething() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("say something hero: " + name);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
