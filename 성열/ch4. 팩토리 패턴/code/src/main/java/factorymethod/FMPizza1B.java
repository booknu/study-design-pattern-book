package factorymethod;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class FMPizza1B extends Pizza {
	protected FMPizza1B() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseB();
		super.dough = new DoughB();
		super.sauce = new SauceB();
		super.veggies = new Veggie[]{ new VeggieB() };
	}
}
