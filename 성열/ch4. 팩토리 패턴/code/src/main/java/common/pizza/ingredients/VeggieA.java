package common.pizza.ingredients;

public class VeggieA implements Veggie {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
