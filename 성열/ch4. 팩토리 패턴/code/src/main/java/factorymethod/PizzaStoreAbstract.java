package factorymethod;

import common.pizza.Pizza;
import common.type.PizzaType;

/**
 * 팩토리 메소드 패턴에서는 어떤 구현을 사용할지 서브클래스에서 결정하는 framework 를 만들 수 있음.
 * 간단한 팩토리의 경우 여러 방식으로 객체를 생성하는 로직을 추가하기 어렵지만,
 * 팩토리 메소드에서는 concrete creator 클래스만 하나 추가해주면 다른 방식으로 객체를 생성해주는 팩토리를 만들 수 있음.
 */
public abstract class PizzaStoreAbstract {
	/** 객체 생성 의존성을 서브클래스로 캡슐화 (팩토리 역할을 하는 메소드) */
	protected abstract Pizza create(PizzaType pizzaType);

	public final Pizza order(PizzaType pizzaType) {
		// 서브클래스의 팩토리 메소드 로직으로 객체 생성 (이 클래스와 객체 생성과의 의존성은 없음!)
		Pizza pizza = create(pizzaType);

		// 팩토리 메소드로 생성한 객체는 concrete Pizza 와 의존성 없이 인터페이스만으로 하고 싶은 일을 할 수 있음.
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}
