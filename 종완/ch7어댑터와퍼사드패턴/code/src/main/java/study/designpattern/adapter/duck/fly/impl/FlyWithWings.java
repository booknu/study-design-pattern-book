package study.designpattern.adapter.duck.fly.impl;

import study.designpattern.adapter.duck.fly.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("이 오리는 날고 있어요!");
    }
    
}
