package study.designpattern.facade;

import study.designpattern.facade.hometheater.Amplifier;
import study.designpattern.facade.hometheater.DVDPlayer;
import study.designpattern.facade.hometheater.Screen;

public class HomeTheatherFacade {
    
    private Amplifier amp;
    private DVDPlayer dvd;
    private Screen screen;

    public void on(){
        System.out.println("홈 씨어터 시스템 ON");
        amp.on();
        amp.setVolume(20);
        screen.goDown();
        dvd.on();
        dvd.setDvd("SAM-572");
    }

    public void off(){
        System.out.println("홈 씨어터 시스템 OFF");
        amp.off();
        screen.goUp();
        dvd.off();
    }

    
    public HomeTheatherFacade(Amplifier amp, DVDPlayer dvd, Screen screen){
        this.amp = amp;
        this.dvd = dvd;
        this.screen = screen;
    }
}
