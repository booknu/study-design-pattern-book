package queue.command;

import basic.command.BasicCommand;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Supplier;

public abstract class SynchronizedCommand implements BasicCommand {
	protected final ReadWriteLock lock;

	public SynchronizedCommand() {
		lock = new ReentrantReadWriteLock();
	}

	@Override
	public final void execute() {
		afterWriteLock(() -> {
			this.synchronizedExecute();
			return null;
		});
	}

	protected final <R> R afterReadLock(Supplier<R> function) {
		lock.readLock().lock();

		try {
			return function.get();
		} finally {
			lock.readLock().unlock();
		}
	}

	protected final <R> R afterWriteLock(Supplier<R> function) {
		lock.writeLock().lock();

		try {
			return function.get();
		} finally {
			lock.writeLock().unlock();
		}
	}

	protected abstract void synchronizedExecute();
}
