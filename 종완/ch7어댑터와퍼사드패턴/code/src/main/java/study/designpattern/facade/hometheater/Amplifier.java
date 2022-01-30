package study.designpattern.facade.hometheater;

public class Amplifier {

    private int volume;
    private boolean power;

    public Amplifier(){
        this.volume = 0;
    }

    public void on(){
        this.power = true;
    }

    public void off(){
        this.power = false;
    }

    public boolean getPower(){
        return this.power;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public int getVolume(){
        return this.volume;
    }
    
}
