package common.pizza.ingredients;

public class DoughA implements Dough {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
