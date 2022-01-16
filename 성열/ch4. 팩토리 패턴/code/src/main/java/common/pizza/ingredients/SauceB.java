package common.pizza.ingredients;

public class SauceB implements Sauce {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
