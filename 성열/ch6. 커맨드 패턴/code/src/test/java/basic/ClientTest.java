package basic;

import basic.command.*;
import basic.invoker.RemoteControl;
import basic.receiver.Door;
import basic.receiver.Tv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 실질적으로 concrete command 만들고 invoker 에 세팅 & 호출하는건 클라이언트 쪽
 */
public class ClientTest {
	/** invoker */
	private RemoteControl remoteControl;

	/** receiver */
	private Door door;
	private Tv tv;
	private AtomicInteger integer;

	/** command & receiver */
	private SmartCommand smartCommand;

	@BeforeEach
	void setUp() {
		remoteControl = new RemoteControl(5);

		door = new Door();
		tv = new Tv();
		integer = new AtomicInteger(0);
		smartCommand = new SmartCommand();

		TvOnCommand tvOnCommand = new TvOnCommand(tv);
		TvOffCommand tvOffCommand = new TvOffCommand(tv);
		DoorOpenCommand doorOpenCommand = new DoorOpenCommand(door);
		DoorCloseCommand doorCloseCommand = new DoorCloseCommand(door);

		remoteControl.setCommand(0, doorOpenCommand, doorCloseCommand);
		remoteControl.setCommand(1, tvOnCommand, tvOffCommand);
		remoteControl.setCommand(2,
				new MetaCommand(doorOpenCommand, tvOnCommand),
				new MetaCommand(doorCloseCommand, tvOffCommand));
		remoteControl.setCommand(3, smartCommand, smartCommand);
		// 익명 클래스와 같은 형태로도 사용 가능 (보통 Thread 를 이런 식으로 사용)
		remoteControl.setCommand(4, BasicCommand.doNothing(), () -> integer.addAndGet(1));
	}

	@Test
	void 통합테스트() {
		// door
		remoteControl.pushOnButton(0);
		assertTrue(door.isOpen());
		remoteControl.pushOffButton(0);
		assertFalse(door.isOpen());

		// tv
		remoteControl.pushOnButton(1);
		assertTrue(tv.isOn());
		assertEquals(13, tv.getVol());
		remoteControl.pushOffButton(1);
		assertFalse(tv.isOn());

		// door & tv meta command
		remoteControl.pushOnButton(2);
		assertTrue(door.isOpen());
		assertTrue(tv.isOn());
		assertEquals(13, tv.getVol());
		remoteControl.pushOffButton(2);
		assertFalse(door.isOpen());
		assertFalse(tv.isOn());

		// smart command
		remoteControl.pushOnButton(3);
		assertEquals(1, smartCommand.getCount());
		remoteControl.pushOffButton(3);
		assertEquals(2, smartCommand.getCount());

		// no command
		remoteControl.pushOnButton(4);
		assertEquals(0, integer.get());
		remoteControl.pushOffButton(4);
		assertEquals(1, integer.get());
	}
}
