package common.pizza.ingredients;

public class VeggieB implements Veggie {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
