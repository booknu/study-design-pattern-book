package decorator;

import component.Beverage;

import java.util.List;

// abstract decorator
public abstract class CondimentDecorator extends Beverage {
	/**
	 * abstract decorator 쪽에서 component 의 concrete method 를 다시 abstract 하게 만들 수 있음.
	 *
	 * @return
	 */
	@Override
	public abstract List<String> getIngredients();
}
