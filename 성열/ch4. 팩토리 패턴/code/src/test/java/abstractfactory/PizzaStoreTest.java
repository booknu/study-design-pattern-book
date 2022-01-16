package abstractfactory;

import abstractfactory.ingredientfactory.IngredientFactoryA;
import abstractfactory.pizza.AFPizzaA;
import abstractfactory.pizza.AFPizzaB;
import abstractfactory.pizza.AFPizzaC;
import abstractfactory.pizza.AFPizzaD;
import abstractfactory.store.AFPizzaStoreA;
import abstractfactory.store.AFPizzaStoreB;
import abstractfactory.store.AFPizzaStoreGeneral;
import common.pizza.Pizza;
import common.type.PizzaType;
import factorymethod.PizzaStoreAbstract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaStoreTest {
	private PizzaStoreAbstract psa, psb, psg;

	@BeforeEach
	void setUp() {
		psa = new AFPizzaStoreA();
		psb = new AFPizzaStoreB();
		psg = new AFPizzaStoreGeneral(new IngredientFactoryA());
	}

	@Test
	void PizzaStoreA_테스트() {
		assertEquals(expectPizzaName(psa.getClass(), AFPizzaA.class), psa.order(PizzaType.A).getName());
		assertEquals(expectPizzaName(psa.getClass(), AFPizzaB.class), psa.order(PizzaType.B).getName());
		assertEquals(expectPizzaName(psa.getClass(), AFPizzaC.class), psa.order(PizzaType.C).getName());
		assertThatThrownBy(() -> psa.order(PizzaType.D)).isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	void PizzaStoreB_테스트() {
		assertThatThrownBy(() -> psb.order(PizzaType.A)).isInstanceOf(UnsupportedOperationException.class);
		assertEquals(expectPizzaName(psb.getClass(), AFPizzaB.class), psb.order(PizzaType.B).getName());
		assertEquals(expectPizzaName(psb.getClass(), AFPizzaC.class), psb.order(PizzaType.C).getName());
		assertEquals(expectPizzaName(psb.getClass(), AFPizzaD.class), psb.order(PizzaType.D).getName());
	}

	@Test
	void PizzaStoreGeneral_테스트() {
		assertEquals(expectPizzaName(psg.getClass(), AFPizzaA.class), psg.order(PizzaType.A).getName());
		assertEquals(expectPizzaName(psg.getClass(), AFPizzaB.class), psg.order(PizzaType.B).getName());
		assertEquals(expectPizzaName(psg.getClass(), AFPizzaC.class), psg.order(PizzaType.C).getName());
		assertEquals(expectPizzaName(psg.getClass(), AFPizzaD.class), psg.order(PizzaType.D).getName());
	}

	private <PizzaStoreT extends PizzaStoreAbstract, PizzaT extends Pizza> String expectPizzaName (
			Class<PizzaStoreT> pizzaStoreClass,
			Class<PizzaT> pizzaTypeClass) {
		return String.format("[%s] %s", pizzaStoreClass.getSimpleName(), pizzaTypeClass.getSimpleName());
	}
}
