package beverage;

public class TeaMaker extends BeverageMaker {
	@Override
	protected void brew() {
		System.out.println(getClassName() + " 찻잎 우려내는 중...");
	}

	@Override
	protected void addCondiments() {
		System.out.println(getClassName() + " 차에 무언가를 첨가하는 중...");
	}
}
