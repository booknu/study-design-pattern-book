package queue.command;

import lombok.SneakyThrows;

import java.util.Map;

/**
 * 딱히 receiver 로 쓸만한 객체가 없을 떄 command 객체 자체를 receiver 로 사용할 수도 있을듯?
 */
public class SmartCommandAsReceiver extends SynchronizedCommand {
	private Map<String, String> data;

	public SmartCommandAsReceiver() {
		this.data = Map.of("key", "first");
	}

	@Override
	@SneakyThrows
	protected void synchronizedExecute() {
		System.out.println(this.getClass().getSimpleName());
		System.out.printf("[%s] 대충 어디선가 데이터 가져오는 척...\n", Thread.currentThread().getName());
		Thread.sleep(3000);
		System.out.println("데이터 변경 전");
		this.data = Map.of("key", "second");
		System.out.println("데이터 변경 후");
	}

	public String getSomeData(String key) {
		return afterReadLock(() -> {
			return data.get(key);
		});
	}
}
