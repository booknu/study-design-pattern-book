package coffee.decorator.concrete;

import coffee.component.Beverage;
import coffee.decorator.CondimentDecorator;

import java.util.List;

public class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double cost() {
		return 0.01 + beverage.cost();
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = beverage.getIngredients();
		ingredients.add("모카");
		return ingredients;
	}
}
