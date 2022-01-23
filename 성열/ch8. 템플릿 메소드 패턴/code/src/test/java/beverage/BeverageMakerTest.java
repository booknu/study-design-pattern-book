package beverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeverageMakerTest {
	private BeverageMaker coffeeMaker, teaMaker;

	@BeforeEach
	void setUp() {
		coffeeMaker = new CoffeeMaker();
		teaMaker = new TeaMaker();
	}

	@Test
	void coffeeMakerTest() {
		coffeeMaker.makeBeverage();
	}

	@Test
	void teaMakerTest() {
		teaMaker.makeBeverage();
	}
}
