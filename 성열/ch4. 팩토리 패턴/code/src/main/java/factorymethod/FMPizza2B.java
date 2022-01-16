package factorymethod;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class FMPizza2B extends Pizza {
	protected FMPizza2B() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseB();
		super.dough = new DoughB();
		super.sauce = new SauceB();
		super.veggies = new Veggie[]{ new VeggieB() };
	}
}
