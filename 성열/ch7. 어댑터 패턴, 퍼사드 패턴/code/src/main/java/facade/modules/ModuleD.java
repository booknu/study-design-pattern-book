package facade.modules;

import facade.util.StackTraceUtil;

public class ModuleD {
	private void printClassAndMethod() {
		System.out.println(this.getClass().getSimpleName() + " " + StackTraceUtil.getMethodName(1));
	}

	public void a() {
		printClassAndMethod();
	}

	public void b() {
		printClassAndMethod();
	}

	public void c() {
		printClassAndMethod();
	}
}
