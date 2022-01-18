package common.pizza.ingredients;

public class CheeseC implements Cheese {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
