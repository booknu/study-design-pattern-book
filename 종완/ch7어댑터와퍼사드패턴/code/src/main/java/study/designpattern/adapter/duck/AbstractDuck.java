package study.designpattern.adapter.duck;

import study.designpattern.adapter.duck.fly.FlyBehavior;
import study.designpattern.adapter.duck.quack.QuackBehavior;

/**
 * '오리란 모름지기 이래야 한다.'를 정의한 추상 클래스.
 *  즉 오리가 되기 위한 최소요건이다.
 */
public abstract class AbstractDuck implements Duck{
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    /**
     * (안바뀌는 부분) - 수영
     */
    public void swim(){
        System.out.println("어푸어푸");
    }

    /**
     * 바뀌는 부분(클래스별 고유, 유형을 한정짓기 힘듦) - 외관
     */
    public abstract void display();

    /**
     * 바뀌는 부분(클래스별 고유이나 그 유형은 한정되어있음) - 꽥꽥거리기
     */
    public void performQuack(){
        quackBehavior.quack();
    }

    /**
     * 바뀌는 부분(클래스별 고유이나 그 유형은 한정되어있음) - 날기
     */
    public void performFly(){
        flyBehavior.fly();
    }

    /**
     * 나는 방식 바꾸기
     * @param flyBehavior
     */
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    /**
     * 꽥꽥 방식 바꾸기
     * @param quackBehavior
     */
    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }

}