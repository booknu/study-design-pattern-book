package composite;

/**
 * Leaf, Non-Leaf(Composite) 의 틀이 되는 인터페이스.
 * <p>
 * default 로 기본 구현을 예외로 던지도록 준 이유는 Leaf, Non-Leaf 에서는 특정 메소드는 지원을 하지 않을텐데
 * 이런 경우 따로 Override 하는 것 보다 아예 수퍼클래스의 메소드를 그대로 사용하는 것이 더 편할 것 같아서 그런듯.
 * <p>
 * 트리 관리 + 비즈니스 로직 두 가지의 책임을 가지고 있음 (SRP 에 어긋나는 구조)
 * - 그러나 Leaf, Non-Leaf 를 같은 방법으로 제어할 수 있는 투명성을 가지고 있음.
 */
public interface Component extends Iterable<Component> {
	// ---- 역할 1. 트리 자체에 대한 관리 메소드(정확히는 자식트리 관리) ---- //
	default void add(Component component) {
		throw new UnsupportedOperationException();
	}

	default void remove(Component component) {
		throw new UnsupportedOperationException();
	}

	default Component getChild(int index) {
		throw new UnsupportedOperationException();
	}

	// ---- 역할 2. 특정 비즈니스 로직에 대한 메소드 ---- //
	default String getName() {
		throw new UnsupportedOperationException();
	}

	default double getPrice() {
		throw new UnsupportedOperationException();
	}

	default void print() {
		throw new UnsupportedOperationException();
	}
}
