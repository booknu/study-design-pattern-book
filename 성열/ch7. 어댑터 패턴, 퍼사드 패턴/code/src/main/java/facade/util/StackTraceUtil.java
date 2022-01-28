package facade.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StackTraceUtil {
	public String getMethodName(final int depth) {
		final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

		return stackTraceElements[depth + 2].getMethodName();
	}
}
