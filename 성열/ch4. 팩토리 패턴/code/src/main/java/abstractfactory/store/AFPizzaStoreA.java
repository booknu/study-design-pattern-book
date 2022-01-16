package abstractfactory.store;

import abstractfactory.ingredientfactory.IngredientFactory;
import abstractfactory.ingredientfactory.IngredientFactoryA;
import abstractfactory.pizza.AFPizzaA;
import abstractfactory.pizza.AFPizzaB;
import abstractfactory.pizza.AFPizzaC;
import common.pizza.Pizza;
import common.type.PizzaType;
import factorymethod.PizzaStoreAbstract;

/**
 * 팩토리 메소드 패턴 사용.
 * 단, create 내부에서는 추상 팩토리를 이용하여 재료군을 생성해서 사용하는 로직
 */
public class AFPizzaStoreA extends PizzaStoreAbstract {
	private String getPizzaNameWithStoreName(Pizza pizza) {
		return String.format("[%s] %s",
				this.getClass().getSimpleName(),
				pizza.getClass().getSimpleName());
	}

	@Override
	protected Pizza create(PizzaType pizzaType) {
		// store A 에서는 factory A 에서 만든 재료군만 가져와서 씀.
		IngredientFactory ingredientFactory = new IngredientFactoryA();

		return switch (pizzaType) {
			case A -> {
				Pizza pizza = new AFPizzaA(ingredientFactory);
				pizza.setName(getPizzaNameWithStoreName(pizza));
				System.out.println(pizza.getName());
				yield pizza;
			}
			case B -> {
				Pizza pizza = new AFPizzaB(ingredientFactory);
				pizza.setName(getPizzaNameWithStoreName(pizza));
				yield pizza;
			}
			case C -> {
				Pizza pizza = new AFPizzaC(ingredientFactory);
				pizza.setName(getPizzaNameWithStoreName(pizza));
				yield pizza;
			}
			default -> throw new UnsupportedOperationException();
		};
	}
}
