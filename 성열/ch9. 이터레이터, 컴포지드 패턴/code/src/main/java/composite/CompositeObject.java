package composite;

import lombok.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 하위에 서브트리를 가질 수 있음.
 *
 * 서브트리 관리와 비즈니스 로직적인 기능까지 동시에 담당하는 클래스.
 */
@Getter
@ToString(exclude = "childs")
public class CompositeObject implements Component {
	private final String name;
	private final double price;

	@Getter(AccessLevel.NONE)
	private final List<Component> childs;

	public CompositeObject(String name, double price) {
		this.name = name;
		this.price = price;
		this.childs = new ArrayList<>();
	}

	// ---- 역할 1. 트리 자체에 대한 관리 메소드(정확히는 자식트리 관리) ---- //
	@Override
	public void add(@NonNull Component component) {
		this.childs.add(component);
	}

	@Override
	public Component getChild(int index) {
		return this.childs.get(index);
	}

	@Override
	public void remove(@NonNull Component component) {
		this.childs.remove(component);
	}

	// ---- 역할 2. 특정 비즈니스 로직에 대한 메소드 ---- //
	@Override
	public void print() {
		System.out.println("[composite] " + this);

		// 내부 반복자 형태로 구현.
		// 반복자 내부에서 반복 로직이 처리됨.
//		for (Component child : childs) {
//			child.print();
//		}
	}

	// ---- iterator 기능 외부로 노출 ---- //
	/**
	 * 책에서 구현한 방식. root 가 순회에 포함되지 않고, 깊이가 깊은 트리인 경우 O(n^2) 시간과 공간이 필요함.
	 */
	private static class CompositeIterator implements Iterator<Component> {

		private Stack<Iterator<Component>> stack;

		public CompositeIterator(@NonNull Iterator<Component> iterator) {
			stack = new Stack<>();
			stack.push(iterator);
		}

		/**
		 * stack 에서 hasNext = false 인 iterator 들을 스킵함.
		 */
		private void skipInvalidIterator() {
			while (!stack.empty() && !stack.peek().hasNext()) {
				stack.pop();
			}
		}

		@Override
		public boolean hasNext() {
			skipInvalidIterator();
			return !stack.empty();
		}

		@Override
		public Component next() {
			if (!hasNext()) {
				return null;
			}

			skipInvalidIterator();

			Component component = stack.peek().next();
			stack.push(component.iterator());
			return component;
		}
	}

	@Override
	public Iterator<Component> iterator() {
		return new CompositeIterator(this.childs.iterator());
	}

}
