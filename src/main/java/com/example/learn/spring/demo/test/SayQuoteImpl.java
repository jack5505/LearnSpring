package com.example.learn.spring.demo.test;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class SayQuoteImpl implements SayQuote {

    @InjectRandomInt(min = 1, max = 10)
    public int repeat;


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
