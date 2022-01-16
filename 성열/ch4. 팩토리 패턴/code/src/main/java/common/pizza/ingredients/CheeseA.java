package common.pizza.ingredients;

public class CheeseA implements Cheese {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
