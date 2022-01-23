package study.designpattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import study.designpattern.adapter.TurkeyAdapter;
import study.designpattern.adapter.duck.Duck;
import study.designpattern.adapter.duck.MallardDuck;
import study.designpattern.adapter.turkey.Turkey;
import study.designpattern.adapter.turkey.impl.WildTurkey;
import study.designpattern.facade.HomeTheatherFacade;
import study.designpattern.facade.hometheater.Amplifier;
import study.designpattern.facade.hometheater.DVDPlayer;
import study.designpattern.facade.hometheater.Screen;


public class AppTest {
    @Test
    void turkeyTest(){
        Duck turkey = new TurkeyAdapter(new WildTurkey());
        Duck duck = new MallardDuck();
        Turkey turkey2 = new WildTurkey();

        
        System.out.println("=====야생의 칠면조=====");
        turkey2.gobble();
        turkey2.fly();

        System.out.println("=====진짜 청동오리=====");
        duck.performQuack();
        duck.performFly();
    
        System.out.println("=====오리인 척 하는 칠면조의 행동=====");
        turkey.performQuack();
        turkey.performFly();
        
    }

    @Test
    void facade(){
        Amplifier amp = new Amplifier();
        Screen screen = new Screen();
        DVDPlayer dvdPlayer = new DVDPlayer();
        HomeTheatherFacade homeTheater = new HomeTheatherFacade(amp, dvdPlayer, screen);

        homeTheater.on();
        assertTrue(amp.getPower());
        assertTrue(screen.isDown());
        assertTrue(dvdPlayer.isOn());
        assertEquals(dvdPlayer.getDvd(), "SAM-572");
        
        homeTheater.off();
        assertFalse(amp.getPower());
        assertFalse(screen.isDown());
        assertFalse(dvdPlayer.isOn());
    }

}
