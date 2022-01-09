package observerpattern.impl;

import java.util.ArrayList;

import observerpattern.Observer;
import observerpattern.Subject;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private double temperature, humidity, pressure;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(구독자 -> 구독자.update(temperature, humidity, pressure));
    }
    
    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(double 기온, double 습도, double 기압){
        this.temperature = 기온;
        this.humidity = 습도;
        this.pressure = 기압;
        measurementsChanged();
    }
}
