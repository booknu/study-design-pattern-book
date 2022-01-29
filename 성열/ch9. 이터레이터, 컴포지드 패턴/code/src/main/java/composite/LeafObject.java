package composite;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Iterator;

/**
 * Leaf 에서는 서브트리 관리 관련 메소드는 override 하지 않기 때문에 서브트리 추가 불가능하다는 제약 조건을 걸 수 있음.
 */
@RequiredArgsConstructor
@Getter
@ToString
public class LeafObject implements Component {
	private final String name;
	private final double price;

	@Override
	public void print() {
		System.out.println("[leaf] " + this);
	}

	// ---- iterator 기능 외부로 노출 ---- //
	private static class NullIterator implements Iterator<Component> {
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Component next() {
			return null;
		}
	}

	@Override
	public Iterator<Component> iterator() {
		return new NullIterator();
	}
}
