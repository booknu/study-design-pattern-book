package gumballmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MachineIntegratedTest {
	private GumballMachine machine;

	@BeforeEach
	void setUp() {
		this.machine = new GumballMachine();
	}

	@Test
	void 정상적으로_한_게임_하는_경우() {
		machine.insertCoin(101);
		machine.turnCrank();
		machine.ejectCoin();

		assertEquals(0, machine.getCoin());
		assertEquals(States.READY, machine.getState());
	}

	@Test
	void 여러게임_하는_경우() {
		machine.insertCoin(501);
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank(); // 부족
		assertEquals(States.COIN_INSERTED, machine.getState());

		machine.ejectCoin();

		assertEquals(0, machine.getCoin());
		assertEquals(States.READY, machine.getState());
	}

	@Test
	void 볼이_동날때까지_게임하는_경우() {
		machine.insertCoin(10000);
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		assertEquals(0, machine.getCoin());
		assertEquals(States.SOLD_OUT, machine.getState());
	}

	@Test
	void 볼이_동날때까지_게임하고_리필하는_경우() {
		machine.insertCoin(10000);
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		machine.turnCrank();
		assertEquals(0, machine.getCoin());
		assertEquals(States.SOLD_OUT, machine.getState());

		machine.refill(100);
		assertEquals(100, machine.getBalls());
		assertEquals(States.READY, machine.getState());
	}

	@Test
	void 코인부족_케이스() {
		machine.insertCoin(99);
		machine.turnCrank();
		machine.turnCrank();

		assertEquals(States.COIN_INSERTED, machine.getState());
	}
}
