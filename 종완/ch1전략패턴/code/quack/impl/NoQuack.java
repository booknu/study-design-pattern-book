package 종완.ch1전략패턴.code.quack.impl;

import 종완.ch1전략패턴.code.quack.QuackBehavior;

public class NoQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("(조용)");
    }
    
}
