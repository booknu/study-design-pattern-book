package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.iterator.IterableTree;
import tree.tree.TreeNode;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TreeTest {
	private int pow(int a, int n) {
		int ret;
		for(ret = 1; n > 0; a = a*a, n /= 2) { if(n%2==1) ret = ret*a; }
		return ret;
	}

	private TreeNode<Integer> createCompleteTree(int width, int depth) {
		int id = 0;
		TreeNode<Integer> root = TreeNode.create(id++);

		List<TreeNode<Integer>> lastLayer = List.of(root);
		List<TreeNode<Integer>> currentLayer = null;

		for (int d = 0; d < depth; ++d) {
			currentLayer = new ArrayList<>();
			for (var node : lastLayer) {
				for (int w = 0; w < width; ++w) {
					var newNode = TreeNode.create(id++);
					node.add(newNode);
					currentLayer.add(newNode);
				}
			}
			lastLayer = currentLayer;
		}

		System.out.println("size: " + id);

		return root;
	}

	private <T> void forEach(Iterator<T> iterator, Consumer<T> action) {
		while (iterator.hasNext()) {
			action.accept(iterator.next());
		}
	}

	private <T> Stream<T> stream(Iterator<T> iterator) {
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),
				false);
	}

	private TreeNode<Integer> root;

	@BeforeEach
	void setUp() {
		root = createCompleteTree(2, 10);
	}

	// 테스트도 귀찮아서 대충 시각화만 함.
	@Test
	void eulerTourTest() {
		System.out.println(stream(root.eulerTourIterator())
				.map(TreeNode::getItem)
				.collect(Collectors.toList()));
	}

	@Test
	void preorderIterator() {
		System.out.println(stream(root.iterator(IterableTree.IterateOrder.PREORDER))
				.map(TreeNode::getItem)
				.collect(Collectors.toList()));
	}

	@Test
	void leafIteratorTest() {
		System.out.println(stream(root.leafIterator())
				.map(TreeNode::getItem)
				.collect(Collectors.toList()));
	}

	@Test
	void itemIterator() {
		System.out.println(stream(root.iterator())
				.collect(Collectors.toList()));
	}
}
