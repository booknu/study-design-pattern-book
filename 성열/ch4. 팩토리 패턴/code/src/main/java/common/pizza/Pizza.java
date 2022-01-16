package common.pizza;

import common.pizza.ingredients.Cheese;
import common.pizza.ingredients.Dough;
import common.pizza.ingredients.Sauce;
import common.pizza.ingredients.Veggie;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Pizza {
	/** name 은 외부에서 유동적으로 바뀔 수 있는 요소임. */
	@Setter
	protected String name;
	protected Dough dough;
	protected Cheese cheese;
	protected Sauce sauce;
	protected Veggie[] veggies;

	public abstract void prepare();

	public void bake() {
		System.out.println("Bake!");
	}

	public void cut() {
		System.out.println("Cut!");
	}

	public void box() {
		System.out.println("Box!");
	}
}

