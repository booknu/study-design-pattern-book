package basic.invoker;

import basic.command.BasicCommand;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoteControl {
	@Getter
	private final int numberOfCommands;
	private final List<BasicCommand> onCommands;
	private final List<BasicCommand> offCommands;

	public RemoteControl(int numberOfCommands) {
		this.numberOfCommands = numberOfCommands;

		onCommands = Stream.generate(BasicCommand::doNothing)
				.limit(numberOfCommands)
				.collect(Collectors.toList());

		offCommands = Stream.generate(BasicCommand::doNothing)
				.limit(numberOfCommands)
				.collect(Collectors.toList());
	}

	public void setCommand(int slot, BasicCommand onCommand, BasicCommand offCommand) {
		onCommands.set(slot, convertToProperCommand(onCommand));
		offCommands.set(slot, convertToProperCommand(offCommand));
	}

	private BasicCommand convertToProperCommand(BasicCommand command) {
		if (command == null) {
			return BasicCommand.doNothing();
		}

		return command;
	}

	public void pushOnButton(int slot) {
		onCommands.get(slot).execute();
	}

	public void pushOffButton(int slot) {
		offCommands.get(slot).execute();
	}
}
