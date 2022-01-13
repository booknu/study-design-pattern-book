package coffee.decorator.concrete;

import coffee.component.Beverage;
import coffee.decorator.CondimentDecorator;

import java.util.List;

public class Whip extends CondimentDecorator {
	public Whip(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double cost() {
		return 0.0001 + beverage.cost();
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = beverage.getIngredients();
		ingredients.add("휘핑");
		return ingredients;
	}
}
