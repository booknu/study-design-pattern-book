package tree.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tree.iterator.PeekableIterator;
import tree.iterator.IterableTree;

import java.util.Iterator;

public interface TreeNode<T> extends Iterable<T>, IterableTree<T> {
	T getItem();
	void setItem(T newItem);
	int getChildSize();
	default boolean isLeaf() {
		return getChildSize() == 0;
	}

	void add(TreeNode<T> node);
	void remove(TreeNode<T> node);
	void remove(int index);
	TreeNode<T> getChildNode(int index);

	/**
	 * 자식 노드만 순회하는 iterator
	 * @param <T>
	 */
	@AllArgsConstructor
	class ChildNodeIterator<T> implements PeekableIterator<TreeNode<T>> {
		@Getter
		public TreeNode<T> node;
		private int childPointer;

		public ChildNodeIterator(TreeNode<T> node) {
			this.node = node;
		}

		@Override
		public boolean hasNext() {
			return childPointer < node.getChildSize();
		}

		@Override
		public TreeNode<T> next() {
			if (!hasNext()) {
				return null;
			}

			return node.getChildNode(childPointer++);
		}

		@Override
		public TreeNode<T> peek() {
			if (!hasNext()) {
				return null;
			}

			return node.getChildNode(childPointer);
		}
	}

	default ChildNodeIterator<T> childIterator() {
		return new ChildNodeIterator<>(this);
	}

	/**
	 * TreeNode iterator 을 Item iterator 로 변환해주는 iterator
	 * @param <T>
	 */
	class ItemIterator<T> implements Iterator<T> {
		private final Iterator<TreeNode<T>> treeIterator;

		public ItemIterator(Iterator<TreeNode<T>> treeIterator) {
			this.treeIterator = treeIterator;
		}

		@Override
		public boolean hasNext() {
			return treeIterator.hasNext();
		}

		@Override
		public T next() {
			if (!treeIterator.hasNext()) {
				return null;
			}

			return treeIterator.next().getItem();
		}
	}

	@Override
	default Iterator<T> iterator() {
		return new ItemIterator<T>(iterator(IterateOrder.PREORDER));
	}

	static <T> TreeNode<T> create(T item) {
		return new NonLeafTreeNode<>(item);
	}

	static <T> TreeNode<T> createLeaf(T item) {
		return new LeafNode<>(item);
	}
}
