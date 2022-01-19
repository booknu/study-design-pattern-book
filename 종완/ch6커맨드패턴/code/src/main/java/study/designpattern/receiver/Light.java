package study.designpattern.receiver;

import lombok.Getter;

@Getter
public class Light {
    private boolean isOn = false;

    public void turnOn(){
        System.out.println("전등이 켜집니다");
        isOn = true;
    }

    public void turnOff(){
        System.out.println("전등이 꺼집니다");
        isOn = false;
    }
    
}
