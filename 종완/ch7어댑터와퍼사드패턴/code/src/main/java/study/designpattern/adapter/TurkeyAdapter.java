package study.designpattern.adapter;

import study.designpattern.adapter.duck.Duck;
import study.designpattern.adapter.turkey.Turkey;


public class TurkeyAdapter implements Duck {
    private Turkey turkey;

    @Override
    public void swim() {
        
    }

    @Override
    public void performQuack() {
        turkey.gobble();
    }

    @Override
    public void performFly() {
        for(int i=0; i<5; i++) turkey.fly();
    }

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

}
