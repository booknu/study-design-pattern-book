package 종완.ch1전략패턴.code.fly.impl;

import 종완.ch1전략패턴.code.fly.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("이 오리는 날고 있어요!");
    }
    
}
