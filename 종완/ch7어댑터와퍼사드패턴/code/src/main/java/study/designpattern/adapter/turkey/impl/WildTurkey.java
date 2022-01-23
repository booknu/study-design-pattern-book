package study.designpattern.adapter.turkey.impl;

import study.designpattern.adapter.turkey.Turkey;

public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble Gobble");        
    }

    @Override
    public void fly() {
        System.out.println("칠면조가 짧게 날고 있다");        
    }
    
}
