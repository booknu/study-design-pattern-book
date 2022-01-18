package coffee.component;

import coffee.component.types.BeverageSize;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// abstract component
public abstract class Beverage {
	// description 도 abstract 메소드로 만들어서 아예 Beaverage 를 interface 로 만들면 안 되나?
	// interface 를 abstract class 로 바꾸는 상황이 올 수도 있어서?
	// 아니면 abstract decorator 에서 getDescription() 을 다시 abstract 하게 만드는걸 보여주기 위해서?
	// 책에서는 상황에 맞게 쓰라고만 나옴.
	@Getter
	protected List<String> ingredients = new ArrayList<>();

	@Getter
	@Setter
	private BeverageSize size = BeverageSize.TALL;

	public String getDescription() {
		return String.join(", ", getIngredients());
	}

	public abstract double cost();
}
