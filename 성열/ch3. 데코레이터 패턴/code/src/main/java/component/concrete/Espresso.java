package component.concrete;

import component.Beverage;

import java.util.Collections;
import java.util.List;

public class Espresso extends Beverage {
	public Espresso() {
		this.ingredients.add("에스프레소");
	}

	@Override
	public double cost() {
		return 100;
	}
}
