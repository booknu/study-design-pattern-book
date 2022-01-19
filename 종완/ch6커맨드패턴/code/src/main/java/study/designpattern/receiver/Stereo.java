package study.designpattern.receiver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stereo {

    private String cd, dvd, radio;
    private int volume;
    private boolean powerOn;

    public Stereo(){
        this.volume = 0;
        this.powerOn = false;
    }

    public void on(){
        this.powerOn = true;
    }

    public void off(){
        this.powerOn = false;
    }

    
}
