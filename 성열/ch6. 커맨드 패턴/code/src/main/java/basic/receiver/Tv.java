package basic.receiver;

import lombok.Getter;

@Getter
public class Tv {
	private boolean on;
	private int vol;

	public void turnOn() {
		if (!on) {
			System.out.println("TV 켜기!");
			on = true;
			vol = 13;
		}
	}

	public void turnOff() {
		if (on) {
			System.out.println("TV 끄기!");
			on = false;
		}
	}
}
