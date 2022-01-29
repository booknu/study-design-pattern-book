package iterator;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 대충 객체들의 컬렉션을 관리하는 객체.
 * Iterable 을 구현하면 Java 의 for-each 문법을 사용할 수 있다.
 *
 * @param <T>
 */
public class CustomCollection<T> implements Iterable<T> {
	@Getter
	private final int maxSize;
	private List<T> list;

	public CustomCollection(int maxSize) {
		this.maxSize = maxSize;
		list = new ArrayList<>();
	}

	// ---- 대충 아무런 collection 관리 기능들 ---- //
	public T get(int index) {
		return list.get(index);
	}

	public void add(T item) {
		if (list.size() >= maxSize) {
			throw new ArrayStoreException("배열이 가득 참");
		}
		list.add(item);
	}

	public int size() {
		return list.size();
	}

	public T remove(int index) {
		return list.remove(index);
	}

	/**
	 * List.iterator 가 있지만, 어떤 식으로 구현되는지 보여주기 위함.
	 *
	 * @param <T>
	 */
	private static class CustomCollectionIterator<T> implements Iterator<T> {
		private final List<T> list;
		private int pointer;

		public CustomCollectionIterator(@NonNull final List<T> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			return pointer < list.size();
		}

		@Override
		public T next() {
			return list.get(pointer++);
		}

		@Override
		public void remove() {
			if (pointer <= 0) {
				throw new IllegalStateException("next() 를 한 번도 호출하지 않음.");
			}

			list.remove(pointer);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomCollectionIterator<>(list);
	}
}
