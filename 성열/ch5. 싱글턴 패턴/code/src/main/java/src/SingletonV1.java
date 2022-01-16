package src;

/**
 * 가장 고전적인 싱글턴 패턴
 *
 * - lazy initialization : yes
 * - thread safe : no
 * - no thread bottleneck : yes
 * - reflection safe : no
 */
public class SingletonV1 {
	private static SingletonV1 instance;

	private SingletonV1() {
		System.out.println("객체 생성 : " + this.getClass().getSimpleName());
	}

	public static SingletonV1 getInstance() {
		if (instance == null) {
			instance = new SingletonV1();
		}

		return instance;
	}
}
