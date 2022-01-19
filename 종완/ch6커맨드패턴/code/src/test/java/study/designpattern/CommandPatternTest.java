package study.designpattern;

import org.junit.jupiter.api.Test;

import study.designpattern.command.CeilingFanHigh;
import study.designpattern.command.CeilingFanLow;
import study.designpattern.command.CeilingFanMedium;
import study.designpattern.command.CeilingFanOff;
import study.designpattern.command.LightOff;
import study.designpattern.command.LightOn;
import study.designpattern.command.StereoCDWithdrawal;
import study.designpattern.command.StereoWithCDCommand;
import study.designpattern.invoker.RemoteControl;
import study.designpattern.receiver.CeilingFan;
import study.designpattern.receiver.CeilingFanSpeed;
import study.designpattern.receiver.Light;
import study.designpattern.receiver.Stereo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandPatternTest {
    @Test
    void testApp() {
        RemoteControl remocon = new RemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();
        CeilingFan ceilingFan = new  CeilingFan();

        remocon.setCommand(0, new LightOn(light), new LightOff(light));
        remocon.setCommand(1, new StereoWithCDCommand(stereo), new StereoCDWithdrawal(stereo));
        remocon.setCommand(2, new CeilingFanHigh(ceilingFan), new CeilingFanOff(ceilingFan));
        remocon.setCommand(3, new CeilingFanMedium(ceilingFan), new CeilingFanOff(ceilingFan));
        remocon.setCommand(4, new CeilingFanLow(ceilingFan), new CeilingFanOff(ceilingFan));

        //전등 테스트
        remocon.pushOnButton(0);
        assertTrue(light.isOn());
        
        remocon.pushOffButton(0);
        assertFalse(light.isOn());


        //전축 테스트
        remocon.pushOnButton(1);
        assertEquals(stereo.getCd(), "CD");

        remocon.pushOffButton(1);
        assertFalse(stereo.isPowerOn());


        //선풍기 테스트
        remocon.pushOnButton(2);
        assertEquals(ceilingFan.getSpped(), CeilingFanSpeed.HIGH);
        remocon.pushOffButton(2);
        assertEquals(ceilingFan.getSpped(), CeilingFanSpeed.OFF);

        remocon.pushOnButton(3);
        assertEquals(ceilingFan.getSpped(), CeilingFanSpeed.MEDIUM);
        remocon.pushOffButton(3);
        assertEquals(ceilingFan.getSpped(), CeilingFanSpeed.OFF);

        remocon.pushOnButton(4);
        assertEquals(ceilingFan.getSpped(), CeilingFanSpeed.LOW);
        remocon.pushOffButton(4);
        assertEquals(ceilingFan.getSpped(), CeilingFanSpeed.OFF);
        
        //실행취소 테스트
        remocon.pushOnButton(2);
        remocon.pushOffButton(2);
        remocon.undo();
        assertEquals(ceilingFan.getSpped(), CeilingFanSpeed.HIGH);

    }
}
