package abstractfactory.pizza;

import abstractfactory.ingredientfactory.IngredientFactory;
import common.pizza.Pizza;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AFPizzaD extends Pizza {
	private final IngredientFactory ingredientFactory;

	@Override
	public void prepare() {
		System.out.println("Pizza D 준비");
		super.dough = ingredientFactory.creteDough();
	}
}
