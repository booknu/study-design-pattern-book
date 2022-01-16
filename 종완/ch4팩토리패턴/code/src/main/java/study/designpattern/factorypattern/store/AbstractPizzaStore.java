package study.designpattern.factorypattern.store;

import study.designpattern.factorypattern.pizza.AbstractPizza;

/**
 * 모든 피자의 체인점은 이 표준을 따라야한다
 */
public abstract class AbstractPizzaStore {

    /**
     * 피자 주문 메소드, 모든 가게는 이 절차대로 만들어야하므로 오버라이드 할 수 없다.
     * @param name 피자 이름
     * @return 주문하신 피자
     */
    public final AbstractPizza orderPizza(String name){
        AbstractPizza pizza;
        pizza = createPizza(name);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * 팩토리 메소드, 객체 생성에 관한 일련의 절차를 캡슐화하였다.
     * 근데 이름을 String으로 받는 것이 마음에 안든다, Enum으로는 처리 못하는건가?
     * @param name 피자 이름
     * @return 가게마다 고유한 피자
     */
    protected abstract AbstractPizza createPizza(String name);

}
