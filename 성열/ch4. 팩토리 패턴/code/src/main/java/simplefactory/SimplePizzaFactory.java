package simplefactory;

import common.pizza.Pizza;
import common.type.PizzaType;

/**
 * Pizza 인스턴스를 생성하는 작업을 factory 로 캡슐화하자! (static factory)
 * Pizza 인스턴스 생성에 대한 동작은 전부 이 클래스가 담당하기 때문에 다른 클래스에서는 인스턴스 생성 의존성이 없어진다.
 */
public class SimplePizzaFactory {
	public static Pizza createPizza(PizzaType pizzaType) {
		return switch (pizzaType) {
			case A -> new NaivePizzaA();
			case B -> new NaivePizzaB();
			case C -> new NaivePizzaC();
			default -> throw new UnsupportedOperationException(String.format("'%s' 타입은 지원하지 않음.", pizzaType));
		};
	}
}
