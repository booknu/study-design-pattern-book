package simplefactory;

import common.pizza.Pizza;
import common.pizza.ingredients.*;
import common.type.PizzaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplePizzaStoreTest {
	private SimplePizzaStore pizzaStore;

	@BeforeEach
	void setUp() {
		pizzaStore = new SimplePizzaStore();
	}

	@Test
	void A_타입_피자_주문() {
		Pizza a = pizzaStore.order(PizzaType.A);
		assertEquals(NaivePizzaA.class.getSimpleName(), a.getName());
		assertThat(a.getCheese()).isInstanceOf(CheeseA.class);
		assertThat(a.getSauce()).isInstanceOf(SauceA.class);
		assertThat(a.getDough()).isInstanceOf(DoughA.class);

		assertThat(Arrays.stream(a.getVeggies())
				.map(Veggie::name)
				.collect(Collectors.toList()))
				.hasSameElementsAs(List.of(new VeggieA().name(), new VeggieC().name()));
	}

	@Test
	void 다른_피자_주문() {
		List<String> names = Stream.of(PizzaType.A, PizzaType.B, PizzaType.C)
				.map(pizzaStore::order)
				.map(Pizza::getName)
				.collect(Collectors.toList());

		assertEquals(List.of(
				NaivePizzaA.class.getSimpleName(),
				NaivePizzaB.class.getSimpleName(),
				NaivePizzaC.class.getSimpleName()), names);
	}

	@Test
	void 지원하지_않는_피자_주문() {
		assertThatThrownBy(() -> pizzaStore.order(PizzaType.D)).isInstanceOf(UnsupportedOperationException.class);
	}
}
