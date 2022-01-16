package factorymethod;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class FMPizza1C extends Pizza {
	protected FMPizza1C() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseC();
		super.dough = new DoughC();
		super.sauce = new SauceC();
		super.veggies = new Veggie[]{ new VeggieC() };
	}
}
