package adapter;

import java.util.Enumeration;
import java.util.Iterator;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration 을 Iterator 로 사용할 수 있도록 변환.
 *
 * 실제로는 Enumeration 자체에서 asIterator() 를 지원하기 때문에 굳이 adapter 을 구현할 필요는 없음.
 *
 * @param <T>
 */
public record EnumerationAdapter<T>(Enumeration<T> enumeration) implements Iterator<T> {

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    /**
     * remove 는 Iterator 내부에서 default 로 UnsupportedOperationException 을 던지도록 구현되어 있지만, 이렇게 구현 불가능한
     * 메소드는 예외로 처리할 수 있다는걸 보여주기 위해 직접 구현
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
