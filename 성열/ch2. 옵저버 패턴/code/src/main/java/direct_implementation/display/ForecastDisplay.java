package direct_implementation.display;

import direct_implementation.DisplayElement;
import direct_implementation.WeatherDataValue;
import direct_implementation.observer.Observable;
import direct_implementation.observer.Observer;

public class ForecastDisplay implements Observer<WeatherDataValue>, DisplayElement {
	private Observable<WeatherDataValue> observer;
	private WeatherDataValue weatherDataValue;

	public ForecastDisplay(Observable<WeatherDataValue> weatherDataValueObservable) {
		this.observer = weatherDataValueObservable;
		this.weatherDataValue = observer.getData();
		this.observer.addObserver(this);
	}

	@Override
	public void display() {
		if (this.weatherDataValue == null) {
			System.out.println("예보 정보 없음.");
			return;
		}

		System.out.println("대충 예보 정보 디스플레이 " + this.weatherDataValue);
	}

	@Override
	public void onUpdate(WeatherDataValue data) {
		this.weatherDataValue = data;
	}
}
