package adapter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.*;

public class EnumerationIteratorTest {

    @Test
    void EnumerationToIteratorTest() {
        Vector<Integer> vector = IntStream.range(0, 10)
            .boxed()
            .collect(Collectors.toCollection(Vector::new));

        Iterator<Integer> it = new EnumerationAdapter<>(vector.elements());

        for (Integer num : vector) {
            assertTrue(it.hasNext());
            assertEquals(num, it.next());
        }

        assertFalse(it.hasNext());
        assertThatThrownBy(it::next).isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(it::remove).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void IteratorToEnumerationTest() {
        List<Integer> list = IntStream.range(0, 10)
                .boxed()
                .toList();

        Enumeration<Integer> e = new IteratorAdapter<>(list.iterator());

        for (Integer num : list) {
            assertTrue(e.hasMoreElements());
            assertEquals(num, e.nextElement());
        }

        assertFalse(e.hasMoreElements());
        assertThatThrownBy(e::nextElement).isInstanceOf(NoSuchElementException.class);
    }
}
