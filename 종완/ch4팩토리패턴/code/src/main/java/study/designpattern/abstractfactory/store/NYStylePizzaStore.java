package study.designpattern.abstractfactory.store;

import study.designpattern.abstractfactory.factory.NYPizzaIndegredientFactory;
import study.designpattern.abstractfactory.pizza.*;

public class NYStylePizzaStore extends AbstractPizzaStore {

    @Override
    protected AbstractPizza createPizza(String name) {
        //피자이름들이 나올 것이다
        switch(name){

            default:
            return new NYStyleCheesePizza(new NYPizzaIndegredientFactory());
        }
    }

}
