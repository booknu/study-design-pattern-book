package study.designpattern.factorypattern.store;

import study.designpattern.factorypattern.pizza.AbstractPizza;
import study.designpattern.factorypattern.pizza.ChicagoPizza;

public class ChicagoPizzaStore extends AbstractPizzaStore {

    @Override
    protected AbstractPizza createPizza(String name) {
        return new ChicagoPizza();
    }
    
}
