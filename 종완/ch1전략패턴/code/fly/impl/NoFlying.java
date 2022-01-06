package 종완.ch1전략패턴.code.fly.impl;

import 종완.ch1전략패턴.code.fly.FlyBehavior;

public class NoFlying implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("(이 오리는 날 수 없습니다.)");
    }
    
}
