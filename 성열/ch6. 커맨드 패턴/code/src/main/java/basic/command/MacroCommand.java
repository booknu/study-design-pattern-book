package basic.command;

import java.util.Arrays;
import java.util.Collection;

public class MacroCommand implements BasicCommand {
	private final BasicCommand[] commands;

	public MacroCommand(BasicCommand... commands) {
		this.commands = commands;
	}

	public MacroCommand(Collection<BasicCommand> commands) {
		this(commands.toArray(BasicCommand[]::new));
	}

	@Override
	public void execute() {
		Arrays.stream(commands).forEach(BasicCommand::execute);
	}
}
