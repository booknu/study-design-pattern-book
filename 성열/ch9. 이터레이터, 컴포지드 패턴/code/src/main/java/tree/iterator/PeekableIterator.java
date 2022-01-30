package tree.iterator;

import java.util.Iterator;

public interface PeekableIterator<T> extends Iterator<T> {
	T peek();
}
