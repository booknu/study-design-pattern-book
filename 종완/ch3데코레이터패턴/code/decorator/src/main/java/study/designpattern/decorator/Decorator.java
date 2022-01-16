package study.designpattern.decorator;

import study.designpattern.cake.Cake;

/**
 * Cake를 장식할 Decorator Class
 */
public abstract class Decorator extends Cake {

    Cake cake;

    public Decorator(Cake cake){
        this.cake = cake;
    }

        
}
