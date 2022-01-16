package common.pizza.ingredients;

public class DoughB implements Dough {
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
