package abstractfactory.store;

import abstractfactory.ingredientfactory.IngredientFactory;
import abstractfactory.ingredientfactory.IngredientFactoryA;
import abstractfactory.ingredientfactory.IngredientFactoryB;
import abstractfactory.pizza.AFPizzaA;
import abstractfactory.pizza.AFPizzaB;
import abstractfactory.pizza.AFPizzaC;
import abstractfactory.pizza.AFPizzaD;
import common.pizza.Pizza;
import common.type.PizzaType;
import factorymethod.PizzaStoreAbstract;

public class AFPizzaStoreB extends PizzaStoreAbstract {
	private String getPizzaNameWithStoreName(Pizza pizza) {
		return String.format("[%s] %s",
				this.getClass().getSimpleName(),
				pizza.getClass().getSimpleName());
	}

	@Override
	protected Pizza create(PizzaType pizzaType) {
		// store A 에서는 factory A 에서 만든 재료군만 가져와서 씀.
		IngredientFactory ingredientFactory = new IngredientFactoryB();

		return switch (pizzaType) {
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
			default -> throw new UnsupportedOperationException();
		};
	}
}
