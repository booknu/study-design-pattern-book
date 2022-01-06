package observerpattern;

import observerpattern.impl.CurrentConditionDisplay;
import observerpattern.impl.WeatherData;

public class App {
    
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        DisplayElement displayElement = new CurrentConditionDisplay(weatherData);
        
        weatherData.setMeasurements(19.8, 19.0, 1.0);
        weatherData.setMeasurements(29.8, 93.4, 1.0);
        weatherData.setMeasurements(24.5, 30.2, 1.1);
    }
}
