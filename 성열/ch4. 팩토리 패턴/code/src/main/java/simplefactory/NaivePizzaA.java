package simplefactory;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class NaivePizzaA extends Pizza {
	/**
	 * 외부에서는 new 로 객체를 생성하지 못하도록 막기
	 */
	protected NaivePizzaA() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseA();
		super.dough = new DoughA();
		super.sauce = new SauceA();
		super.veggies = new Veggie[]{ new VeggieA(), new VeggieC() };
	}
}
