package tree.tree;

import lombok.Getter;
import lombok.Setter;
import tree.iterator.PeekableIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NonLeafTreeNode<T> implements TreeNode<T> {
	@Getter
	@Setter
	private T item;
	private List<TreeNode<T>> childs;

	public NonLeafTreeNode(T item) {
		this.item = item;
		this.childs = new ArrayList<>();
	}

	private static class EulerTourIterator<T> implements PeekableIterator<TreeNode<T>> {
		private final Stack<ChildNodeIterator<T>> nodeIteratorStack;
		private boolean currentlyPopped; // 방금 전에 stack 에서 pop 됐는지?

		public EulerTourIterator(TreeNode<T> rootNode) {
			nodeIteratorStack = new Stack<>();
			nodeIteratorStack.push(rootNode.childIterator());
			currentlyPopped = true; // 첫 root 를 방문하기 위한 꼼수
		}

		private void popStack() {
			nodeIteratorStack.pop();
			currentlyPopped = true;
		}

		private void skipInvalidIterator() {
			if (!currentlyPopped && !nodeIteratorStack.empty() && !nodeIteratorStack.peek().hasNext()) {
				popStack();
			}
		}

		@Override
		public TreeNode<T> peek() {
			if (!hasNext()) {
				return null;
			}

			skipInvalidIterator();

			// 방금 전에 한 쪽의 subtree 순회가 끝나고 현재 노드로 돌아온 경우 부모 노드를 순회에 추가
			if (currentlyPopped) {
				return nodeIteratorStack.peek().getNode();
			}

			// 현재 순회 중인 노드의 다음 자식이 있으면 peek
			assert(nodeIteratorStack.peek().hasNext());
			return nodeIteratorStack.peek().peek();
		}

		@Override
		public boolean hasNext() {
			skipInvalidIterator();
			return !nodeIteratorStack.empty() && (currentlyPopped || nodeIteratorStack.peek().hasNext());
		}

		@Override
		public TreeNode<T> next() {
			if (!hasNext()) {
				return null;
			}

			skipInvalidIterator();

			TreeNode<T> node = peek();

			if (currentlyPopped) {
				currentlyPopped = false;
			} else {
				nodeIteratorStack.push(nodeIteratorStack.peek().next().childIterator());
			}

			return node;
		}
	}

	@Override
	public PeekableIterator<TreeNode<T>> eulerTourIterator() {
		return new EulerTourIterator<>(this);
	}

	@Override
	public int getChildSize() {
		return childs.size();
	}

	@Override
	public void add(TreeNode<T> node) {
		childs.add(node);
	}

	@Override
	public void remove(TreeNode<T> node) {
		childs.remove(node);
	}

	@Override
	public void remove(int index) {
		childs.remove(index);
	}

	@Override
	public TreeNode<T> getChildNode(int index) {
		return childs.get(index);
	}
}
