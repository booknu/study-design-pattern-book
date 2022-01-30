package study.designpattern.receiver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CeilingFan {
    private CeilingFanSpeed spped;

    public void off(){
        this.spped = CeilingFanSpeed.OFF;
    }

    public void low(){
        this.spped = CeilingFanSpeed.LOW;
    }
    
    public void medium(){
        this.spped = CeilingFanSpeed.MEDIUM;
    }

    public void high(){
        this.spped = CeilingFanSpeed.HIGH;
    }

}
