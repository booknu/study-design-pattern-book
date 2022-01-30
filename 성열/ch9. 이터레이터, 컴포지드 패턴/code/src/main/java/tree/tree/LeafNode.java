package tree.tree;

import lombok.Getter;
import lombok.Setter;
import tree.iterator.PeekableIterator;

/**
 * 서브트리를 생성 할 수 없는 노드 객체
 *
 * @param <T>
 */
public class LeafNode<T> implements TreeNode<T> {
	@Getter
	@Setter
	private T item;

	public LeafNode(T item) {
		this.item = item;
	}

	private static class SingleItemIterator<T> implements PeekableIterator<T> {
		private boolean finished;
		private T item;

		public SingleItemIterator(T item) {
			this.item = item;
		}

		@Override
		public boolean hasNext() {
			return !finished;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				return null;
			}

			this.finished = true;
			return item;
		}

		@Override
		public T peek() {
			if (!hasNext()) {
				return null;
			}

			return item;
		}
	}

	@Override
	public PeekableIterator<TreeNode<T>> eulerTourIterator() {
		return new SingleItemIterator<>(this);
	}

	@Override
	public int getChildSize() {
		return 0;
	}

	@Override
	public void add(TreeNode<T> node) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(TreeNode<T> node) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public TreeNode<T> getChildNode(int index) {
		throw new UnsupportedOperationException();
	}
}
