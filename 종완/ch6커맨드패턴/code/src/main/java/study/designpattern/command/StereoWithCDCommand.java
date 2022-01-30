package study.designpattern.command;

import lombok.AllArgsConstructor;
import study.designpattern.receiver.Stereo;

@AllArgsConstructor
public class StereoWithCDCommand implements Command<Stereo> {

    private Stereo stereo;

    @Override
    public void execute() {
        stereo.on();
        System.out.println("CD 삽입 중");
        stereo.setCd("CD");
        stereo.setVolume(20);
    }

    @Override
    public void undo() {
        stereo.setPowerOn(false);
        stereo.setCd(null);
    }

    @Override
    public Stereo getReceiver() {
        return this.stereo;
    }
    
}
