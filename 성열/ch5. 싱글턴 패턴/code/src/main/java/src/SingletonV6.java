package src;

/**
 * Lazy Holder 을 이용한 싱글턴 패턴
 *
 * 가장 보편적으로 사용되는 싱글턴 구현 방식.
 *
 * - lazy initialization : yes
 * - thread safe : yes
 * - no thread bottleneck : yes
 * - reflection safe : no
 */
public class SingletonV6 {
	/**
	 * static member class
	 * 내부 클래스에서 static 변수를 선언해야 하는 경우 사용.
	 * static 멤버/메소드에서 사용될 목적으로 선언
	 */
	private static class ObjectHolder {
		/**
		 * getInstance() 호출 시 초기화.
		 * classloader 가 초기화 과정을 진행할 때 ObjectHolder 를 초기화 하지 않고,
		 * - 동적 바인딩 특징을 이용하여 성능이 뛰어남.
		 */
		private static final SingletonV6 instance = new SingletonV6();
	}

	private SingletonV6() {
		System.out.println("객체 생성 : " + this.getClass().getSimpleName());
	}

	public static SingletonV6 getInstance() {
		return ObjectHolder.instance;
	}
}
