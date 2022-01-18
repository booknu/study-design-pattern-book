package src;

/**
 * 메소드 자체를 동기화 시키는 싱글턴 패턴
 *
 * - lazy initialization : yes
 * - thread safe : yes
 * - no thread bottleneck : no
 * - reflection safe : no
 */
public class SingletonV2 {
	private static SingletonV2 instance;

	private SingletonV2() {
		System.out.println("객체 생성 : " + this.getClass().getSimpleName());
	}

	public static synchronized SingletonV2 getInstance() {
		if (instance == null) {
			instance = new SingletonV2();
		}

		return instance;
	}
}
