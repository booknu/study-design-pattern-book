package common.pizza.ingredients;

public class CheeseB implements Cheese {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
