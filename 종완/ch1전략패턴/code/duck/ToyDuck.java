package 종완.ch1전략패턴.code.duck;

import 종완.ch1전략패턴.code.fly.impl.NoFlying;
import 종완.ch1전략패턴.code.quack.impl.Squeak;

/**
 * 이 장난감 오리는 날지는 못하지만 시끄럽게 삑삑거립니다.
 */
public class ToyDuck extends Duck{

    public ToyDuck(){
        this.flyBehavior = new NoFlying();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("=================장난감 오리=================");
    }
    
}
