package basic.command;

import basic.receiver.Door;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DoorCloseCommand implements BasicCommand {
	private final Door door;

	@Override
	public void execute() {
		door.close();
	}
}
