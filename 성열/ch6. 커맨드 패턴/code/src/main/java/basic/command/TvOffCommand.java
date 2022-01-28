package basic.command;

import basic.receiver.Tv;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TvOffCommand implements BasicCommand {
	private final Tv tv;

	@Override
	public void execute() {
		tv.turnOff();
	}
}
