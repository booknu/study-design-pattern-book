package study.designpattern.adapter.duck.quack.impl;

import study.designpattern.adapter.duck.quack.QuackBehavior;

public class Squeak implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("삑삑");
    }
    
}
