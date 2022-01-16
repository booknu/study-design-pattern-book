package study.designpattern.abstractfactory.store;

import study.designpattern.abstractfactory.pizza.AbstractPizza;

/**
 * K-피자전문점 중 하나인 피자스쿨
 */
public class PizzaSchool extends AbstractPizzaStore {

    @Override
    protected AbstractPizza createPizza(String name) {
        switch(name){
            case "치즈":
            return new AbstractPizza() {

                @Override
                public void prepare() {
                    
                }
            };

            case "감자":

            return null;

            case "고구마":

            return null;


            default:
            return null;
        }
    }
    
}
