package abstractfactory.store;

import abstractfactory.ingredientfactory.IngredientFactory;
import abstractfactory.ingredientfactory.IngredientFactoryB;
import abstractfactory.pizza.AFPizzaA;
import abstractfactory.pizza.AFPizzaB;
import abstractfactory.pizza.AFPizzaC;
import abstractfactory.pizza.AFPizzaD;
import common.pizza.Pizza;
import common.type.PizzaType;
import factorymethod.PizzaStoreAbstract;

public class AFPizzaStoreGeneral extends PizzaStoreAbstract {
	private IngredientFactory ingredientFactory;

	/**
	 * 아예 ingredient factory 를 인자로 받아서 만들게 할 수도 있음.
	 *
	 * @param ingredientFactory
	 */
	public AFPizzaStoreGeneral(IngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	private String getPizzaNameWithStoreName(Pizza pizza) {
		return String.format("[%s] %s",
				this.getClass().getSimpleName(),
				pizza.getClass().getSimpleName());
	}

	@Override
	protected Pizza create(PizzaType pizzaType) {
		return switch (pizzaType) {
			case A -> {
				Pizza pizza = new AFPizzaA(ingredientFactory);
				pizza.setName(getPizzaNameWithStoreName(pizza));
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
			case D -> {
				Pizza pizza = new AFPizzaD(ingredientFactory);
				pizza.setName(getPizzaNameWithStoreName(pizza));
				yield pizza;
			}
		};
	}
}
