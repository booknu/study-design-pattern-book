package decorator.concrete;

import component.Beverage;
import decorator.CondimentDecorator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Milk extends CondimentDecorator {
	private final Beverage beverage;

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
