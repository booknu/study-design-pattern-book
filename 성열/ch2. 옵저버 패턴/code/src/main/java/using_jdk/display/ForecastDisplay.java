package using_jdk.display;

import using_jdk.DisplayElement;
import using_jdk.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
	private Observable observer;

	private float temperature;
	private float humidity;
	private float pressure;

	public ForecastDisplay(Observable weatherDataValueObservable) {
		this.observer = weatherDataValueObservable;
		this.observer.addObserver(this);
	}

	@Override
	public void display() {
		System.out.printf("대충 예보 정보 디스플레이 : %.1f, %.1f, %.1f\n", temperature, humidity, pressure);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			display();
		}
	}
}
