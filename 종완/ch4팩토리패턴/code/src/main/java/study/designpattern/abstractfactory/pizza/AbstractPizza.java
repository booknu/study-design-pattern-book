package study.designpattern.abstractfactory.pizza;
import java.util.ArrayList;

import study.designpattern.abstractfactory.factory.PizzaIndegredientFactory;
import study.designpattern.abstractfactory.ingredient.Cheese;
import study.designpattern.abstractfactory.ingredient.Dough;
import study.designpattern.abstractfactory.ingredient.Pepperoni;
import study.designpattern.abstractfactory.ingredient.Sauce;

/**
 * 추상 피자 클래스.
 */
public abstract class AbstractPizza {
    String name;
    //피자 클래스를 구성하는 재료들을 인터페이스로 묶었다.
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Pepperoni pepperoni;
    PizzaIndegredientFactory indegredientFactory;
    
    abstract public void prepare();

    public void bake(){
        System.out.println("피자 굽는 중");
    }

    public void cut(){
        System.out.println("피자 조각내는 중");
    }

    public void box(){
        System.out.println("피자가 포장되었습니다.");
    }
    
}
