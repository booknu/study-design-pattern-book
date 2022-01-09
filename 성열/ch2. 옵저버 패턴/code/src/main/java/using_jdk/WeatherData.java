package using_jdk;

import lombok.Getter;

import java.util.Observable;

// Java 9 부터 Observable, Observer 는 deprecated 됨.
@Getter
public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;

	public void measurementsChanged() {
		// Observable 내부 변수 change=false 인 경우 notifyObservers 호출해도 notify 되지 않음.
		// clearChanged 로 change=false 로 설정할 수도 있음.
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		this.measurementsChanged();
	}
}
