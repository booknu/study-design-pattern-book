package decorator.concrete;

import component.Beverage;
import decorator.CondimentDecorator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Whip extends CondimentDecorator {
	private final Beverage beverage;

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
