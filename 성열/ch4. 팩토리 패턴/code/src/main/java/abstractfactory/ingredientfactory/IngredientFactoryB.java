package abstractfactory.ingredientfactory;

import common.pizza.ingredients.*;

public class IngredientFactoryB implements IngredientFactory {
	@Override
	public Cheese createCheese() {
		return new CheeseB();
	}

	@Override
	public Dough creteDough() {
		return new DoughB();
	}

	@Override
	public Sauce createSauce() {
		return new SauceB();
	}

	@Override
	public Veggie[] createVeggies() {
		return new Veggie[] { new VeggieB() };
	}
}
