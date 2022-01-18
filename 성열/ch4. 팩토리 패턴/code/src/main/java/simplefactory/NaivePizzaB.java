package simplefactory;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class NaivePizzaB extends Pizza {
	/**
	 * 외부에서는 new 로 객체를 생성하지 못하도록 막기
	 */
	protected NaivePizzaB() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseB();
		super.dough = new DoughB();
		super.sauce = new SauceB();
		super.veggies = new Veggie[]{ new VeggieB(), new VeggieC() };
	}
}
