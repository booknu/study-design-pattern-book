package study.designpattern.adapter.duck.quack.impl;

import study.designpattern.adapter.duck.quack.QuackBehavior;

public class NoQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("(조용)");
    }
    
}
