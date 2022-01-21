package queue;

import basic.command.BasicCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.command.PrimeCalculator;
import queue.command.SmartCommandAsReceiver;
import queue.exception.ObjectNotReadyException;
import queue.invoker.CommandQueue;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientTest {
	private CommandQueue commandQueue;

	private PrimeCalculator primeCalculator;
	private SmartCommandAsReceiver smartCommandAsReceiver;

	@BeforeEach
	void setUp() {
		commandQueue = new CommandQueue();
		primeCalculator = new PrimeCalculator(1_000_000_00);
		smartCommandAsReceiver = new SmartCommandAsReceiver();
	}

	@Test
	void 통합테스트() throws InterruptedException {
		// 대충 producer 쪽
		Thread producer = new Thread(() -> {
			try {
				Thread.sleep(3000);
				System.out.println("queue 에 넣음!");
				commandQueue.add(primeCalculator);
				System.out.println("queue 에 넣음!");
				commandQueue.add(smartCommandAsReceiver);
				System.out.println(commandQueue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Set<String> finished = Collections.synchronizedSet(new HashSet<>());

		// 대충 consumer 쪽
		Thread consumer = new Thread(() -> {
			BasicCommand command;

			while((command = commandQueue.poll()) != null) {
				System.out.println("poll " + command.getClass().getSimpleName());
				command.execute();

				// finished 에 추가
				finished.add(command.getClass().getSimpleName());
			}
		});

		// 대충 client 쪽
		Thread client = new Thread(() -> {
			while (true) {
				boolean primeFinished = finished.contains(PrimeCalculator.class.getSimpleName());

				if (primeFinished) {
					// 준비됐을 떄
					assertThat(primeCalculator.fractionalDecomposition(8)).hasSameElementsAs(List.of(2, 2, 2));
				} else {
					// 준비되지 않았을 때
					// CAUTION: 동기화 처리가 제대로 되어있지 않기 때문에 primeFinished 구한 후 이 코드 실행되기 전까지 준비가 완료됐을 수 있음.
					assertThatThrownBy(() -> primeCalculator.fractionalDecomposition(8)).isInstanceOf(ObjectNotReadyException.class);
				}

				boolean scrFinished = finished.contains(SmartCommandAsReceiver.class.getSimpleName());

				if (scrFinished) {
					// 준비됐을 떄
					assertEquals("second", smartCommandAsReceiver.getSomeData("key"));
				} else {
					// 준비되지 않았을 때
					// CAUTION: 동기화 처리가 제대로 되어있지 않기 때문에 primeFinished 구한 후 이 코드 실행되기 전까지 준비가 완료됐을 수 있음.
					assertEquals("first", smartCommandAsReceiver.getSomeData("key"));
				}

				if (primeFinished && scrFinished) {
					break;
				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		});

		producer.start();
		consumer.start();
		client.start();

		producer.join();
		consumer.join();
		client.join();
	}
}
