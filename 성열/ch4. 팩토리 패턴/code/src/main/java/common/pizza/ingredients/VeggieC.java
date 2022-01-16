package common.pizza.ingredients;

public class VeggieC implements Veggie {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
