package study.designpattern.command;

import lombok.AllArgsConstructor;
import study.designpattern.receiver.Light;

@AllArgsConstructor
public class LightOn implements Command<Light> {
    private Light light;

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();        
    }

    @Override
    public Light getReceiver() {
        return this.light;
    }
    
}
