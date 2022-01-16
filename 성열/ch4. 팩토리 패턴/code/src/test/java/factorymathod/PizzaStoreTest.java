package factorymathod;

import common.type.PizzaType;
import factorymethod.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PizzaStoreTest {
	private PizzaStoreAbstract ps1, ps2;

	@BeforeEach
	void setUp() {
		ps1 = new PizzaStore1();
		ps2 = new PizzaStore2();
	}

	@Test
	void PizzaStore1_테스트() {
		assertThat(ps1.order(PizzaType.A)).isInstanceOf(FMPizza1A.class);
		assertThat(ps1.order(PizzaType.B)).isInstanceOf(FMPizza1B.class);
		assertThat(ps1.order(PizzaType.C)).isInstanceOf(FMPizza1C.class);
		assertThatThrownBy(() -> ps1.order(PizzaType.D)).isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	void PizzaStore2_테스트() {
		assertThatThrownBy(() -> ps2.order(PizzaType.A)).isInstanceOf(UnsupportedOperationException.class);
		assertThat(ps2.order(PizzaType.B)).isInstanceOf(FMPizza2B.class);
		assertThat(ps2.order(PizzaType.C)).isInstanceOf(FMPizza2C.class);
		assertThat(ps2.order(PizzaType.D)).isInstanceOf(FMPizza2D.class);
	}
}

