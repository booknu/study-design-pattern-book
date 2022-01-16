package common.pizza.ingredients;

public class DoughC implements Dough {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
