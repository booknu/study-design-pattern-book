package study.designpattern.adapter.duck;

import study.designpattern.adapter.duck.fly.impl.FlyWithWings;
import study.designpattern.adapter.duck.quack.impl.Quack;

/**
 * 청동오리, 이 오리는 날 수 있고 꽥꽥거리기도 한다.
 */
public class MallardDuck extends AbstractDuck{

    public MallardDuck(){
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("=================청동오리=================");
    }

    
}
