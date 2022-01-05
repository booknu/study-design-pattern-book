package 종완.ch1전략패턴.code.duck;

import 종완.ch1전략패턴.code.fly.impl.NoFlying;
import 종완.ch1전략패턴.code.quack.impl.NoQuack;

/**
 * 목업 오리 클래스, 꽥꽥거리지도 날지도 못한다.
 */
public class DecoyDuck extends Duck {

    public DecoyDuck(){
        this.flyBehavior = new NoFlying();
        this.quackBehavior = new NoQuack();
    }

    @Override
    public void display() {
        System.out.println("=================목업 오리=================");
    }
    
}
