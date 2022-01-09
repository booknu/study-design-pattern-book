package direct_implementation.display;

import direct_implementation.DisplayElement;
import direct_implementation.WeatherDataValue;
import direct_implementation.observer.Observable;
import direct_implementation.observer.Observer;

public class CurrentConditionDisplay implements Observer<WeatherDataValue>, DisplayElement {
	private Observable<WeatherDataValue> observer;
	private WeatherDataValue weatherDataValue;

	public CurrentConditionDisplay(Observable<WeatherDataValue> weatherDataValueObservable) {
		this.observer = weatherDataValueObservable;
		this.weatherDataValue = observer.getData();
		this.observer.addObserver(this);
	}

	@Override
	public void display() {
		if (this.weatherDataValue == null) {
			System.out.println("현재 상태 : 정보 없음.");
			return;
		}

		System.out.printf("현재 상태 : 온도=%.1fF degrees, 습도=%.1f%%\n",
				weatherDataValue.temperature(), weatherDataValue.humidity());
	}

	@Override
	public void onUpdate(WeatherDataValue data) {
		this.weatherDataValue = data;
	}
}
