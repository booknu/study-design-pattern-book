package common.pizza.ingredients;

public class SauceC implements Sauce {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
