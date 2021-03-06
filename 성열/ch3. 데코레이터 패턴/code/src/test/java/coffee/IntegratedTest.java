package coffee;

import coffee.component.Beverage;
import coffee.component.concrete.Espresso;
import coffee.component.types.BeverageSize;
import coffee.decorator.concrete.Milk;
import coffee.decorator.concrete.Whip;
import coffee.factory.CoffeeMachine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegratedTest {
	private final double EPS = 1e-7;

	@Test
	void 생성자로_라떼_휘핑추가_만들어보기() {
		Beverage b = new Espresso();
		b = new Milk(b);
		b = new Whip(b);

		assertEquals(b.getIngredients(), List.of("에스프레소", "우유", "휘핑"));
		assertEquals(b.cost(), 100.1001, EPS);
	}

	@Test
	void 커피머신_사용해보기() {
		Beverage b = CoffeeMachine.houseBlend()
				.addMilk()
				.addMocha()
				.addSoy()
				.addWhip()
				.make();

		assertEquals(b.getIngredients(), List.of("하우스 블렌드", "우유", "모카", "두유", "휘핑"));
		assertEquals(b.cost(), 201.1111, EPS);
	}

	@Test
	void aggregator_사용해보기() {
		Beverage b = CoffeeMachine.espresso()
				.addMilk()
				.addMocha()
				.addMilk()
				.addMocha()
				.addMocha()
				.addWhip()
				.aggregateCondiments()
				.make();

		assertThat(b.getIngredients()).hasSameElementsAs(List.of("에스프레소", "휘핑", "우유 2", "모카 3"));
	}

	@Test
	void 사이즈_바꿔보기() {
		Beverage b = CoffeeMachine.espresso()
				.addSoy()
				.size(BeverageSize.VENTI)
				.make();

		assertEquals(b.cost(), 103.001, EPS);
	}
}
