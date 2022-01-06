package 종완.ch1전략패턴.code;

import 종완.ch1전략패턴.code.duck.*;
import 종완.ch1전략패턴.code.fly.impl.NoFlying;

public class Client {

    public static void main(String[] args) {
        Duck 가짜오리 = new DecoyDuck();
        가짜오리.display();
        가짜오리.performQuack();
        가짜오리.performFly();

        Duck 장난감오리 = new ToyDuck();
        장난감오리.display();
        장난감오리.performQuack();
        장난감오리.performFly();
        
        
        Duck 청동오리 = new MallardDuck();
        청동오리.display();
        청동오리.performQuack();
        청동오리.performFly();
        청동오리.swim();
        System.out.println("===그런데 이 오리는 날개를 다쳐서 더이상 못 날게 되었습니다..===");
        청동오리.setFlyBehavior(new NoFlying());
        청동오리.performFly();

        System.out.println("==============끝==============");
    }
    
}
