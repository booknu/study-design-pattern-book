package abstractfactory.ingredientfactory;

import common.pizza.ingredients.*;

public class IngredientFactoryA implements IngredientFactory {
	@Override
	public Cheese createCheese() {
		return new CheeseA();
	}

	@Override
	public Dough creteDough() {
		return new DoughA();
	}

	@Override
	public Sauce createSauce() {
		return new SauceA();
	}

	@Override
	public Veggie[] createVeggies() {
		return new Veggie[] { new VeggieA() };
	}
}
