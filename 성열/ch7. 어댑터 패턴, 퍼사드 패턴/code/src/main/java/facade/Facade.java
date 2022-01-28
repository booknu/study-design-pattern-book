package facade;

import facade.modules.ModuleA;
import facade.modules.ModuleB;
import facade.modules.ModuleC;
import facade.modules.ModuleD;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Facade {
	private final ModuleA moduleA;
	private final ModuleB moduleB;
	private final ModuleC moduleC;
	private final ModuleD moduleD;

	public void someMethod1() {
		moduleA.a();
		moduleA.b();
		moduleB.c();
		moduleB.a();
		moduleC.c();
	}

	public void someMethod2() {
		moduleB.a();
		moduleB.b();
		moduleB.c();
		moduleD.b();
		moduleD.c();
	}
}
