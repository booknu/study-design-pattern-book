package simplefactory;

import common.pizza.Pizza;
import common.type.PizzaType;

public class SimplePizzaStore {
	public Pizza order(PizzaType pizzaType) {
		// 객체 생성 의존성을 factory 에 부여함.
		Pizza pizza = SimplePizzaFactory.createPizza(pizzaType);

		// 이 객체에서는 concrete Pizza 객체와 의존성 없이 인터페이스만으로 하고 싶은 일을 할 수 있음.
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}
