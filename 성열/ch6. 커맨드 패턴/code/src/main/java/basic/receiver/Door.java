package basic.receiver;

import lombok.Getter;

@Getter
public class Door {
	private boolean open;

	public void open() {
		if (!open) {
			System.out.println("문 열기!");
			open = true;
		}
	}

	public void close() {
		if (open) {
			System.out.println("문 닫기!");
			open = false;
		}
	}
}
