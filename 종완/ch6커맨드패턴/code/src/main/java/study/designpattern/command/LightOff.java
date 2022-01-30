package study.designpattern.command;

import lombok.AllArgsConstructor;
import study.designpattern.receiver.Light;

@AllArgsConstructor
public class LightOff implements Command<Light> {

    private Light light;

    @Override
    public void execute() {
        light.turnOff();
    }
    
    @Override
    public void undo() {
        light.turnOn();
    }

    @Override
    public Light getReceiver() {
        return this.light;
    }


    
}
