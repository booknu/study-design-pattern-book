package study.designpattern.adapter.duck;

import study.designpattern.adapter.duck.fly.impl.NoFlying;
import study.designpattern.adapter.duck.quack.impl.NoQuack;

/**
 * 목업 오리 클래스, 꽥꽥거리지도 날지도 못한다.
 */
public class DecoyDuck extends AbstractDuck {

    public DecoyDuck(){
        this.flyBehavior = new NoFlying();
        this.quackBehavior = new NoQuack();
    }

    @Override
    public void display() {
        System.out.println("=================목업 오리=================");
    }
    
}
