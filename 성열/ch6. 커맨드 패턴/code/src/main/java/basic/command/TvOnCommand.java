package basic.command;

import basic.receiver.Tv;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TvOnCommand implements BasicCommand {
	private final Tv tv;

	@Override
	public void execute() {
		tv.turnOn();
	}
}
