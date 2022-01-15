package study.designpattern.decorator;

import study.designpattern.cake.Cake;

public class Chocolate extends Decorator {

    public Chocolate(Cake cake) {
        super(cake);
    }

    @Override
    public int getCost() {
        return cake.getCost() + 700;
    }
    
}
