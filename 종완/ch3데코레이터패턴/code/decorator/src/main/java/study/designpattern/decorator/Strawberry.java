package study.designpattern.decorator;

import study.designpattern.cake.Cake;

public class Strawberry extends Decorator {

    public Strawberry(Cake cake) {
        super(cake);
    }

    @Override
    public int getCost() {
        return cake.getCost() + 800;
    }

    
}
