package study.designpattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import study.designpattern.factorypattern.pizza.AbstractPizza;
import study.designpattern.factorypattern.store.AbstractPizzaStore;
import study.designpattern.factorypattern.store.ChicagoPizzaStore;
import study.designpattern.factorypattern.store.NYPizzaStore;

class FactoryPatternTest {
    @BeforeEach
    void beforeTest() {
        
    }

    @Test
    void pizzaStoreTest(){
        AbstractPizzaStore nyPizzaStore = new NYPizzaStore();
        AbstractPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        AbstractPizza pizza = nyPizzaStore.orderPizza("pepperoni");
        System.out.println("뉴욕 피자 전문점에서 시킨 피자: " + pizza.getClass().getSimpleName());
        pizza = chicagoPizzaStore.orderPizza("");
        System.out.println("시카고 피자 전문점에서 시킨 피자: " + pizza.getClass().getSimpleName());
    }
}
