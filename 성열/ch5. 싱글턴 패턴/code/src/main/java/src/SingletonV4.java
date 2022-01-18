package src;

/**
 * Double-Check Locking(DCL) 을 이용한 싱글턴 패턴
 *
 * - lazy initialization : yes
 * - thread safe : yes
 * - no thread bottleneck : yes
 * - reflection safe : no
 */
public class SingletonV4 {
	/** 스레드마다 CPU Cache 에 있는 변수를 읽어올 수 있으므로 메모리에서만 값을 읽어오도록 volatile 키워드 사용 */
	private volatile static SingletonV4 instance;

	private SingletonV4() {
		System.out.println("객체 생성 : " + this.getClass().getSimpleName());
	}

	public static SingletonV4 getInstance() {
		if (instance == null) {
			synchronized (SingletonV4.class) {
				if (instance == null) {
					instance = new SingletonV4();
				}
			}
		}
		return instance;
	}
}
