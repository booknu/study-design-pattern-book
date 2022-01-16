package abstractfactory.pizza;

import abstractfactory.ingredientfactory.IngredientFactory;
import common.pizza.Pizza;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AFPizzaB extends Pizza {
	private final IngredientFactory ingredientFactory;

	@Override
	public void prepare() {
		System.out.println("Pizza B 준비");
		super.dough = ingredientFactory.creteDough();
		super.sauce = ingredientFactory.createSauce();
		super.cheese = ingredientFactory.createCheese();
		super.veggies = ingredientFactory.createVeggies();
	}
}
