package basic.command;

import java.util.Arrays;
import java.util.Collection;

public class MetaCommand implements BasicCommand {
	private final BasicCommand[] commands;

	public MetaCommand(BasicCommand... commands) {
		this.commands = commands;
	}

	public MetaCommand(Collection<BasicCommand> commands) {
		this(commands.toArray(BasicCommand[]::new));
	}

	@Override
	public void execute() {
		Arrays.stream(commands).forEach(BasicCommand::execute);
	}
}
