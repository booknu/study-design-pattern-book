package beverage;

public class CoffeeMaker extends BeverageMaker {
	@Override
	protected void brew() {
		System.out.println(getClassName() + " 커피 우려내는 중...");
	}

	@Override
	protected void addCondiments() {
		System.out.println(getClassName() + " 커피에 우유 등 첨가하는 중...");
	}

	/**
	 * 선택적으로 이벤트 훅 메소드를 구현한 모습.
	 */
	@Override
	protected void onFinished() {
		System.out.println(getClassName() + " 커피 완성!");
	}
}
