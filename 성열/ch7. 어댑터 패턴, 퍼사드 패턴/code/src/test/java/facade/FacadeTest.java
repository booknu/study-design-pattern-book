package facade;

import facade.modules.ModuleA;
import facade.modules.ModuleB;
import facade.modules.ModuleC;
import facade.modules.ModuleD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacadeTest {
	private Facade facade;

	private ModuleA a;
	private ModuleB b;
	private ModuleC c;
	private ModuleD d;

	@BeforeEach
	void setUp() {
		a = new ModuleA();
		b = new ModuleB();
		c = new ModuleC();
		d = new ModuleD();

		facade = new Facade(a, b, c, d);
	}

	/**
	 * Facade 를 사용하면 간단한 호출만으로 복합적인 동작 가능.
	 * 클라이언트 쪽에서도 Module 메소드를 직접 호출하는 경우가 적을수록 Module 과의 직접적인 의존성이 적어짐.
	 */
	@Test
	void facadeMethods() {
		facade.someMethod1();
		facade.someMethod2();
	}

	/**
	 * Facade 로는 불가능한 동작은 Module 에 직접 호출도 가능.
	 */
	@Test
	void moduleMethods() {
		a.a();
		b.b();
	}
}
