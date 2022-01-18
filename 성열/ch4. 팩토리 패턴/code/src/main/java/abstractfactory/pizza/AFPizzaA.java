package abstractfactory.pizza;

import abstractfactory.ingredientfactory.IngredientFactory;
import common.pizza.Pizza;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AFPizzaA extends Pizza {
	private final IngredientFactory ingredientFactory;

	@Override
	public void prepare() {
		System.out.println("Pizza A 준비");
		super.dough = ingredientFactory.creteDough();
		super.cheese = ingredientFactory.createCheese();
	}
}
