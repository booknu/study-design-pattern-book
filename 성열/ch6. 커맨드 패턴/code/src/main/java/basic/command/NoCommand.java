package basic.command;

import lombok.NoArgsConstructor;

/**
 * 아무것도 하지 않는 더미용 커맨드 (null 대체 가능)
 */
public class NoCommand implements BasicCommand {
	protected NoCommand() {  }

	@Override
	public void execute() {
	}
}
