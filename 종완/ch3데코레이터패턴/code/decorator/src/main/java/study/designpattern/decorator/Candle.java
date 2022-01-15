package study.designpattern.decorator;

import study.designpattern.cake.Cake;

public class Candle extends Decorator {

    public Candle(Cake cake){
        super(cake);
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + ", 양초";
    }

    @Override
    public int getCost() {
        return cake.getCost() + 400;
    }

}
