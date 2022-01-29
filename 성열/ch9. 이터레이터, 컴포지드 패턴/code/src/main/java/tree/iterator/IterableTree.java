package tree.iterator;

import tree.tree.TreeNode;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public interface IterableTree<T> {
	enum IterateOrder {
		PREORDER, POSTORDER
	}

	/**
	 * 오일러 투어 방식의 iterator
	 *
	 * @return 오일러 투어 방식으로 순회할 수 있는 iterator 반환
	 */
	PeekableIterator<TreeNode<T>> eulerTourIterator();

	class TreeIterator<T> implements PeekableIterator<TreeNode<T>> {
		private final PeekableIterator<TreeNode<T>> eulerTourIterator;
		private Consumer<TreeIterator<T>> skipInvalid;
		private final IterateOrder order;
		private Map<TreeNode<T>, Integer> visitCount; // 귀찮아서 그냥 Map 으로 때려박음. 성능 개선하고 싶으면 해당 노드의 첫번쨰/마지막 방문인지 알 수 있도록 구조 변경 필요.

		public TreeIterator(PeekableIterator<TreeNode<T>> eulerTourIterator, IterateOrder order) {
			this.eulerTourIterator = eulerTourIterator;
			this.order = order;
			this.visitCount = new HashMap<>();

			switch (order) {
				case PREORDER -> skipInvalid = (it) -> {
					while (it.eulerTourIterator.hasNext() && it.getVisitCount(it.eulerTourIterator.peek()) > 0) {
						increaseVisitCount(it.eulerTourIterator.next());
					}
				};

				// postorder 구현하려면 parent 를 알 수 있는 방법이 필요함. (현재 방문이 마지막인지 알아내야 함.)
				case POSTORDER -> throw new InvalidParameterException("알 수 없는 IterateOrder : " + order);

				default -> throw new InvalidParameterException("알 수 없는 IterateOrder : " + order);
			}
		}

		private int getVisitCount(TreeNode<T> node) {
			return visitCount.getOrDefault(node, 0);
		}

		private void increaseVisitCount(TreeNode<T> node) {
			visitCount.putIfAbsent(node, 0);
			visitCount.compute(node, (key, value) -> value + 1);
		}

		@Override
		public TreeNode<T> peek() {
			if (!hasNext()) {
				return null;
			}

			skipInvalid.accept(this);

			return eulerTourIterator.peek();
		}

		@Override
		public boolean hasNext() {
			skipInvalid.accept(this);
			return eulerTourIterator.hasNext();
		}

		@Override
		public TreeNode<T> next() {
			if (!hasNext()) {
				return null;
			}

			skipInvalid.accept(this);

			TreeNode<T> node = eulerTourIterator.next();
			increaseVisitCount(node);
			return node;
		}
	}

	/**
	 * tree 전체를 순회하는 iterator.
	 *
	 * @param order: 트리 순회 순서
	 * @return
	 */
	default PeekableIterator<TreeNode<T>> iterator(IterateOrder order) {
		return new TreeIterator<T>(eulerTourIterator(), order);
	}

	/**
	 * Leaf 만 순회하는 iterator
	 *
	 * @param <T>
	 */
	class LeafIterator<T> implements PeekableIterator<TreeNode<T>> {
		private final PeekableIterator<TreeNode<T>> iterator;

		private LeafIterator(PeekableIterator<TreeNode<T>> iterator) {
			this.iterator = iterator;
		}

		private void skipNonLeaf() {
			while (iterator.hasNext() && iterator.peek().getChildSize() != 0) {
				iterator.next();
			}
		}

		@Override
		public boolean hasNext() {
			skipNonLeaf();
			return iterator.hasNext();
		}

		@Override
		public TreeNode<T> next() {
			if (!iterator.hasNext()) {
				return null;
			}

			skipNonLeaf();
			return iterator.next();
		}

		@Override
		public TreeNode<T> peek() {
			if (!iterator.hasNext()) {
				return null;
			}

			skipNonLeaf();
			return iterator.peek();
		}
	}

	/**
	 * leaf 만 순회하는 iterator.
	 *
	 * @return
	 */
	default PeekableIterator<TreeNode<T>> leafIterator() {
		return new LeafIterator<>(iterator(IterateOrder.PREORDER));
	}
}
