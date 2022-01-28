package beverage;

/**
 * 전체적인 제조 과정을 담고 있는 템플릿 메소드를 포함한 슈퍼 클래스.
 * 멤버 변수가 없는 경우 interface 로도 사용 가능.
 *
 */
public abstract class BeverageMaker {
	/**
	 * 템플릿 메소드.
	 * 알고리즘 전체에 대한 흐름(틀, template)은 슈퍼클래스에서 관리.
	 * 서브클래스에서 override 불가능하게 하려면 final 로 선언.
	 */
	public final void makeBeverage() {
		// abstract 메소드를 포함한 메소드들을 호출하여 전체적인 알고리즘 흐름 정의
		boilWater();
		brew();
		addCondiments();
		pourInCup();

		// 훅 메소드 호출
		onFinished();
	}

	/**
	 * 서브클래스에서 반드시 구현해야 되는 특정 부분 동작들
	 */
	protected abstract void brew();
	protected abstract void addCondiments();

	/**
	 * 서브클래스에서 고수준 모듈의 함수를 호출할 수 있도록 할 수도 있음.
	 *
	 * @return concrete class name
	 */
	protected final String getClassName() {
		return String.format("[%s]", this.getClass().getSimpleName());
	}

	/**
	 * 훅 메소드.
	 * 기본 구현은 슈퍼클래스에서 되어있는 상태에서 서브클래스에서 선택적으로 구현하여 수정할 수 있음.
	 *
	 * [ 용도 ]
	 * - 이벤트 훅 용도
	 * - 기본값이 있는 조건 판단을 위해 사용
	 * - 기본값이 있는 어떤 값을 가져오는데 사용
	 * - 기본 동작은 있는데 서브 클래스에서 수정 가능성이 있는 경우 사용
	 */
	protected void onFinished() {  }

	/**
	 * 슈퍼클래스에서만 사용하는 메소드.
	 */
	private void boilWater() {
		System.out.println(getClassName() + " 물 끓이는 중...");
	}

	/**
	 * 슈퍼클래스에서만 사용하는 메소드.
	 */
	private void pourInCup() {
		System.out.println(getClassName() + " 컵에 담는 중...");
	}
}
