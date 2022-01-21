package basic.command;

/**
 * interface command 는 단순한 실행 함수 밖에 인터페이스로 가지고 있지 않으므로 범용성이 굉장히 높음.
 * Thread 와 비슷하게 실제 행동 함수 하나만 구현하면 됨.
 */
public interface BasicCommand {
	BasicCommand DO_NOTHING_COMMAND = new NoCommand();
	void execute();

	static BasicCommand doNothing() {
		return DO_NOTHING_COMMAND;
	}
}
