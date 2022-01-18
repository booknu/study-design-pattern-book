package factorymethod;

import common.pizza.Pizza;
import common.type.PizzaType;

public class PizzaStore2 extends PizzaStoreAbstract {
	/**
	 * 서브 클래스에서 객체를 생성하는 메소드를 구현한다.
	 * 여기에서만 concrete class 와의 의존성이 생기고, 수퍼클래스는 인터페이스만으로 작업하므로 concrete class 와 의존성이 없다.
	 *
	 * @param pizzaType
	 * @return
	 */
	@Override
	protected Pizza create(PizzaType pizzaType) {
		return switch (pizzaType) {
			case A -> throw new UnsupportedOperationException();
			case B -> new FMPizza2B();
			case C -> new FMPizza2C();
			default -> new FMPizza2D();
		};
	}
}
