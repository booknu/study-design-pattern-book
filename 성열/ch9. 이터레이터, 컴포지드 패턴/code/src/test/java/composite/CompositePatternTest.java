package composite;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CompositePatternTest {
	@Test
	void 통합_테스트() {
		CompositeObject root = new CompositeObject("root", 1);

		root.add(new LeafObject("leaf1", 1));
		root.add(new CompositeObject("depth1-1", 1));
		root.add(new CompositeObject("depth1-2", 1));

		assertThatThrownBy(() -> root.getChild(0).add(new LeafObject("test", 1))).isInstanceOf(UnsupportedOperationException.class);
		root.getChild(1).add(new LeafObject("leaf2", 1));
		root.getChild(2).add(new LeafObject("leaf3", 1));

		// root 를 제외한
		for (Component component : root) {
			component.print();
		}
	}
}
