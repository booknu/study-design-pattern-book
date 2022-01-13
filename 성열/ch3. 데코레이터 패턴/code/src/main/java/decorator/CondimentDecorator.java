package decorator;

import component.Beverage;
import lombok.RequiredArgsConstructor;

import java.util.List;

// abstract decorator
@RequiredArgsConstructor
public abstract class CondimentDecorator extends Beverage {
	protected final Beverage beverage;

	/**
	 * abstract decorator 쪽에서 component 의 concrete method 를 다시 abstract 하게 만들 수 있음.
	 *
	 * @return
	 */
	@Override
	public abstract List<String> getIngredients();
}
