package basic.command;

import basic.receiver.Door;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DoorOpenCommand implements BasicCommand {
	private final Door door;

	@Override
	public void execute() {
		door.open();
	}
}
