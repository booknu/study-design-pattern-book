package adapter;

import java.util.Enumeration;
import java.util.Iterator;
import lombok.RequiredArgsConstructor;

/**
 * Iterator 을 Enumeration 으로 사용할 수 있게 변환.
 *
 * @param <T>
 */
public record IteratorAdapter<T>(Iterator<T> iterator) implements Enumeration<T> {

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public T nextElement() {
        return iterator.next();
    }
}
