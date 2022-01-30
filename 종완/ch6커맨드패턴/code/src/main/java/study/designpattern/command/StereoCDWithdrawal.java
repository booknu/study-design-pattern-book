package study.designpattern.command;

import lombok.AllArgsConstructor;
import study.designpattern.receiver.Stereo;

@AllArgsConstructor
public class StereoCDWithdrawal implements Command<Stereo> {
    private Stereo stereo;

    @Override
    public void execute() {
        System.out.println("CD 꺼내는 중");
        stereo.setCd(null);
        stereo.setPowerOn(false);
    }

    @Override
    public void undo() {
        stereo.setPowerOn(true);
        stereo.setCd("CD");
    }

    @Override
    public Stereo getReceiver() {
        return this.stereo;
    }

    
}
