package src;

/**
 * Enum 클래스를 활용한 싱글턴 패턴
 *
 * 복잡한 직렬화 상황에서도 여러개의 객체가 생성되는 것을 방지함.
 * Enum 이외의 클래스를 상속하는 경우 사용 불가.
 * Context 의존성이 있는 경우 싱글턴 초기화 과정에 Context 라는 의존성 끼어들 수 있음.
 *
 * - lazy initialization : yes
 * - thread safe : yes
 * - no thread bottleneck : yes
 * - reflection safe : yes
 */
public enum SingletonV5 {
	INSTANCE;

	SingletonV5() {
		System.out.println("객체 생성 : " + this.getClass().getSimpleName());
	}
}
