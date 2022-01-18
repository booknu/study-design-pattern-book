package common.pizza.ingredients;

public class SauceA implements Sauce {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
