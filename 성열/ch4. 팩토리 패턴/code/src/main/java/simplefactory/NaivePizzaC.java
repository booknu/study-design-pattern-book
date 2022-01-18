package simplefactory;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class NaivePizzaC extends Pizza {
	/**
	 * 외부에서는 new 로 객체를 생성하지 못하도록 막기
	 */
	protected NaivePizzaC() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseC();
		super.dough = new DoughC();
		super.sauce = new SauceC();
		super.veggies = new Veggie[]{ new VeggieC(), new VeggieD() };
	}
}
