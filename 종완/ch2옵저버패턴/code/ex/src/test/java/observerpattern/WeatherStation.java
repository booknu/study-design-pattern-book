package observerpattern;

import org.junit.BeforeClass;
import org.junit.Test;

import observerpattern.impl.CurrentConditionDisplay;
import observerpattern.impl.WeatherData;

public class WeatherStation {
    WeatherData weatherData;
    DisplayElement displayElement;

    @BeforeClass
    public void init(){
        weatherData = new WeatherData();
        displayElement = new CurrentConditionDisplay(weatherData);
    }

    @Test
    public void 표출시험(){
        weatherData.setMeasurements(19.8, 19.0, 1.0);
        weatherData.setMeasurements(29.8, 93.4, 1.0);
        weatherData.setMeasurements(24.5, 30.2, 1.1);
    }
}
