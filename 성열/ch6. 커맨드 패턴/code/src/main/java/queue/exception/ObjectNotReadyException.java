package queue.exception;

public class ObjectNotReadyException extends RuntimeException {
	public ObjectNotReadyException(String msg) {
		super(msg);
	}
}
