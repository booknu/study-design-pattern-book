package coffee.component.concrete;

import coffee.component.Beverage;

public class Espresso extends Beverage {
	public Espresso() {
		this.ingredients.add("에스프레소");
	}

	@Override
	public double cost() {
		return 100;
	}
}
