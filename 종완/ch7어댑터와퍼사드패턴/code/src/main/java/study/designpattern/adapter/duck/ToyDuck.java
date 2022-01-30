package study.designpattern.adapter.duck;

import study.designpattern.adapter.duck.fly.impl.NoFlying;
import study.designpattern.adapter.duck.quack.impl.Squeak;

/**
 * 이 장난감 오리는 날지는 못하지만 시끄럽게 삑삑거립니다.
 */
public class ToyDuck extends AbstractDuck{

    public ToyDuck(){
        this.flyBehavior = new NoFlying();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("=================장난감 오리=================");
    }
    
}
