package direct_implementation;

import direct_implementation.observer.Observable;
import direct_implementation.observer.Observer;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeatherData implements Observable<WeatherDataValue> {
	private final List<Observer<WeatherDataValue>> observers;

	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = Collections.synchronizedList(new ArrayList<>());
	}

	@Override
	public void addObserver(Observer<WeatherDataValue> observer) {
		observers.add(observer);
	}

	@Override
	public boolean removeObserver(Observer<WeatherDataValue> observer) {
		return observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		WeatherDataValue snapshotValue = getData();

		observers.forEach(observer -> observer.onUpdate(snapshotValue));
	}

	@Override
	public synchronized WeatherDataValue getData() {
		return new WeatherDataValue(temperature, humidity, pressure);
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		synchronized (this) {
			this.temperature = temperature;
			this.humidity = humidity;
			this.pressure = pressure;
		}

		this.measurementsChanged();
	}
}
