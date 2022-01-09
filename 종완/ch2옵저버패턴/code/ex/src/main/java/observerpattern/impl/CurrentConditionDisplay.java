package observerpattern.impl;


import observerpattern.DisplayElement;
import observerpattern.Observer;
import observerpattern.Subject;

public class CurrentConditionDisplay implements DisplayElement, Observer {
    double temperature, humidity, preesure;
    Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double 기온, double 습도, double 기압) {
        this.temperature = 기온;
        this.humidity = 습도;
        this.preesure = 기압;
        display();
    }

    @Override
    public void display() {
        System.out.println(
            String.format(
        """
=========================현재 상태 표시===========================
기온: %f℃
습도: %f％
기압: %fatm
==================================================================
        """, temperature, humidity, preesure)
        );        
    }
    
}
