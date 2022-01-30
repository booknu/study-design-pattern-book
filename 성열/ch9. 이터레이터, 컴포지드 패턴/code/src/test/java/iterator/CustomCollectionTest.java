package iterator;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomCollectionTest {

	/**
	 * 일일히 테스트 메소드 작성하기 귀찮아서 통합으로 작성
	 */
	@Test
	void 통합_테스트() {
		CustomCollection<Integer> arr = new CustomCollection<>(5);

		// 가득 찰 때까지 채워보기
		IntStream.range(0, arr.getMaxSize())
				.boxed()
				.forEach(arr::add);

		// 더 채우면 에러 발생
		assertThatThrownBy(() -> arr.add(-1)).isInstanceOf(ArrayStoreException.class);

		// remove 테스트
		assertEquals(0, arr.remove(0));

		// remove 후 남은 원소 테스트
		assertEquals(4, arr.size());
		assertEquals(5, arr.getMaxSize());
		IntStream.range(0, arr.size()).forEach(i -> assertEquals(i + 1, arr.get(i)));

		// itearable, iteartor 테스트
		{
			int i = 0;
			// iterable 을 구현한 클래스는 for-each 문 사용 가능.
			for (Integer x : arr) {
				++i;
				assertEquals(i, x);
			}
		}
	}
}
