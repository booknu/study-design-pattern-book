package 종완.ch1전략패턴.code.duck;

import 종완.ch1전략패턴.code.fly.impl.FlyWithWings;
import 종완.ch1전략패턴.code.quack.impl.Quack;

/**
 * 청동오리, 이 오리는 날 수 있고 꽥꽥거리기도 한다.
 */
public class MallardDuck extends Duck{

    public MallardDuck(){
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("=================청동오리=================");
    }

    
}
