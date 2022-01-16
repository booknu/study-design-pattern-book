package src;

/**
 * 처음부터 객체를 생성해놓는 싱글턴 패턴
 *
 * - lazy initialization : no
 * - thread safe : yes
 * - no thread bottleneck : yes
 * - reflection safe : no
 */
public class SingletonV3 {
	private final static SingletonV3 instance = new SingletonV3();

	private SingletonV3() {
		System.out.println("객체 생성 : " + this.getClass().getSimpleName());
	}

	public static SingletonV3 getInstance() {
		return instance;
	}
}
