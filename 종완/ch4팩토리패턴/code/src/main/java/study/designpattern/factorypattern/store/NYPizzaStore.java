package study.designpattern.factorypattern.store;

import study.designpattern.factorypattern.pizza.AbstractPizza;
import study.designpattern.factorypattern.pizza.NYStyleCheesePizza;
import study.designpattern.factorypattern.pizza.NYStylePepperoniPizza;

/**
 * 표준을 따르는 뉴욕스타일의 피자를 취급하는 가게
 */
public class NYPizzaStore extends AbstractPizzaStore {

    /**
     * 피자 생성
     */
    @Override
    protected AbstractPizza createPizza(String name) {
        switch(name){
            case "cheese":
                return new NYStyleCheesePizza();
            case "pepperoni":
                return new NYStylePepperoniPizza();
            default:
                return null;
        }
    }
}
