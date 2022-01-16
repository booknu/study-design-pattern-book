package factorymethod;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class FMPizza2C extends Pizza {
	protected FMPizza2C() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseC();
		super.dough = new DoughC();
		super.sauce = new SauceC();
		super.veggies = new Veggie[]{ new VeggieC() };
	}
}
