package using_jdk.display;

import direct_implementation.WeatherDataValue;
import using_jdk.DisplayElement;
import using_jdk.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
	private Observable observer;

	private float temperature;
	private float humidity;

	public CurrentConditionDisplay(Observable weatherDataValueObservable) {
		this.observer = weatherDataValueObservable;
		this.observer.addObserver(this);
	}

	@Override
	public void display() {
		System.out.printf("현재 상태 : 온도=%.1fF degrees, 습도=%.1f%%\n",
				temperature, humidity);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
}
