package study.designpattern.adapter.duck.fly.impl;

import study.designpattern.adapter.duck.fly.FlyBehavior;

public class NoFlying implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("(이 오리는 날 수 없습니다.)");
    }
    
}
