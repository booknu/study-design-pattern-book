package basic;

import basic.command.*;
import basic.invoker.RemoteControl;
import basic.receiver.Door;
import basic.receiver.Tv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	/** command & receiver */
	private SmartCommand smartCommand;

	@BeforeEach
	void setUp() {
		remoteControl = new RemoteControl(5);

		door = new Door();
		tv = new Tv();
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
		// index 4 는 자동으로 NoCommand
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
		remoteControl.pushOffButton(4);
	}
}
