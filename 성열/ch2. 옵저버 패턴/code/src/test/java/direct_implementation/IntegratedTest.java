package direct_implementation;

import direct_implementation.display.CurrentConditionDisplay;
import direct_implementation.display.ForecastDisplay;
import direct_implementation.observer.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IntegratedTest {
	private WeatherData weatherData;

	private List<DisplayElement> displays;

	@BeforeEach
	public void init() {
		weatherData = new WeatherData();

		displays = List.of(new CurrentConditionDisplay(weatherData), new ForecastDisplay(weatherData));
	}

	private void printDisplays() {
		displays.forEach(DisplayElement::display);
		System.out.println();
	}

	@Test
	void 통합_테스트() {
		printDisplays();

		weatherData.setMeasurements(180, 60, 30);
		printDisplays();

		weatherData.setMeasurements(-1, -1, -1);
		printDisplays();

		weatherData.removeObserver((Observer<WeatherDataValue>) displays.get(1));
		weatherData.setMeasurements(1000, 1000, 1000);
		printDisplays();
	}
}
