package coffee.factory;

import coffee.component.Beverage;
import coffee.component.concrete.Espresso;
import coffee.component.concrete.HouseBlend;
import coffee.component.types.BeverageSize;
import coffee.decorator.concrete.*;

public class CoffeeMachine {
	private Beverage beverage;

	private CoffeeMachine(Beverage base) {
		this.beverage = base;
	}

	public static CoffeeMachine espresso() {
		return new CoffeeMachine(new Espresso());
	}

	public static CoffeeMachine houseBlend() {
		return new CoffeeMachine(new HouseBlend());
	}

	public CoffeeMachine addMilk() {
		beverage = new Milk(beverage);
		return this;
	}

	public CoffeeMachine addMocha() {
		beverage = new Mocha(beverage);
		return this;
	}

	public CoffeeMachine addSoy() {
		beverage = new Soy(beverage);
		return this;
	}

	public CoffeeMachine addWhip() {
		beverage = new Whip(beverage);
		return this;
	}

	public CoffeeMachine size(BeverageSize size) {
		beverage.setSize(size);
		return this;
	}

	public CoffeeMachine aggregateCondiments() {
		beverage = new CondimentAggregator(beverage);
		return this;
	}

	public Beverage make() {
		return beverage;
	}
}
