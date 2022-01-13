package component.concrete;

import component.Beverage;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		this.ingredients.add("하우스 블렌드");
	}

	@Override
	public double cost() {
		return 200;
	}
}
