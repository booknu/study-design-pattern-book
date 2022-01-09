package using_jdk;


import direct_implementation.WeatherDataValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import using_jdk.display.CurrentConditionDisplay;
import using_jdk.display.ForecastDisplay;

import java.util.List;
import java.util.Observer;

public class IntegratedTest {
	private WeatherData weatherData;

	private List<DisplayElement> displays;

	@BeforeEach
	public void init() {
		weatherData = new WeatherData();

		displays = List.of(new CurrentConditionDisplay(weatherData), new ForecastDisplay(weatherData));
	}

	@Test
	void 통합_테스트() {
		weatherData.setMeasurements(180, 60, 30);

		weatherData.setMeasurements(-1, -1, -1);

		weatherData.deleteObserver((Observer) displays.get(1));
		weatherData.setMeasurements(1000, 1000, 1000);
	}
}
