package factorymethod;

import common.pizza.Pizza;
import common.pizza.ingredients.*;

public class FMPizza2D extends Pizza {
	protected FMPizza2D() {  }

	@Override
	public void prepare() {
		super.setName(this.getClass().getSimpleName());
		super.cheese = new CheeseA();
		super.dough = new DoughB();
		super.sauce = new SauceC();
		super.veggies = new Veggie[]{ new VeggieD() };
	}
}
