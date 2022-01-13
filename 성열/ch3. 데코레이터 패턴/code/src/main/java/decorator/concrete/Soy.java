package decorator.concrete;

import component.Beverage;
import decorator.CondimentDecorator;

import java.util.List;

public class Soy extends CondimentDecorator {
	public Soy(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double cost() {
		return 0.001 + beverage.cost();
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = beverage.getIngredients();
		ingredients.add("두유");
		return ingredients;
	}
}
