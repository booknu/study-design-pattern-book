package decorator.concrete;

import component.Beverage;
import decorator.CondimentDecorator;

import java.util.List;

public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double cost() {
		return 0.1 + beverage.cost();
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = beverage.getIngredients();
		ingredients.add("우유");
		return ingredients;
	}
}
