package study.designpattern.facade.hometheater;

public class DVDPlayer {
    private boolean power;
    private String dvd;
    
    public void on(){
        this.power = true;
    }

    public void off(){
        this.power = false;
    }

    public void setDvd(String dvd){
        this.dvd = dvd;
    }
    
    public String getDvd(){
        return this.dvd;
    }

    public boolean isOn(){
        return this.power;
    }

    
}
