package coffee.decorator.concrete;

import coffee.component.Beverage;
import coffee.decorator.CondimentDecorator;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 재료 개념이 아닌 것도 가능.
 * 그런데 감싸지는 순서에 따라 이상하게 나올 수도 있는데 이런건 어떻게 처리해야할지?
 */
public class CondimentAggregator extends CondimentDecorator {
	public CondimentAggregator(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double cost() {
		return beverage.cost();
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = beverage.getIngredients();
		System.out.println(ingredients);

		return ingredients.stream()
				.collect(Collectors.collectingAndThen(Collectors.groupingBy(Function.identity(), Collectors.counting()),
						countingMap -> countingMap.entrySet().stream()
								.map(entry -> entry.getKey() + (entry.getValue() > 1 ? " " + entry.getValue() : ""))
								.collect(Collectors.toList())));
	}
}
