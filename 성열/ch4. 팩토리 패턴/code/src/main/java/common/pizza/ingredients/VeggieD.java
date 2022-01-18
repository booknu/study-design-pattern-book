package common.pizza.ingredients;

public class VeggieD implements Veggie {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
