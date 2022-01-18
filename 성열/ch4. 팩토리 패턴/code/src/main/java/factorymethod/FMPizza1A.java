package factorymethod;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class FMPizza1A extends Pizza {
	protected FMPizza1A() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseA();
		super.dough = new DoughA();
		super.sauce = new SauceA();
		super.veggies = new Veggie[]{ new VeggieA() };
	}
}
