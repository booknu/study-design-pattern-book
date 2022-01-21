package queue.invoker;

import basic.command.BasicCommand;
import lombok.SneakyThrows;

//import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CommandQueue {
	private final LinkedBlockingQueue<BasicCommand> commandQueue;

	public CommandQueue() {
		commandQueue = new LinkedBlockingQueue<>();
	}

	@SneakyThrows
	public void add(BasicCommand command) {
		commandQueue.offer(command);
	}

	@SneakyThrows
	public BasicCommand poll() {
		return commandQueue.poll(10, TimeUnit.SECONDS);
	}

	public int size() {
		return commandQueue.size();
	}
}
