package study.designpattern.command;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import study.designpattern.receiver.CeilingFan;
import study.designpattern.receiver.CeilingFanSpeed;

@RequiredArgsConstructor
public class CeilingFanMedium implements Command<CeilingFan> {
    @NonNull private CeilingFan ceilingFan;
    private CeilingFanSpeed prevStatus;

    @Override
    public void execute() {
        this.prevStatus = ceilingFan.getSpped();
        ceilingFan.medium();
    }

    @Override
    public void undo() {
        ceilingFan.setSpped(prevStatus);
    }

    @Override
    public CeilingFan getReceiver() {
        return this.ceilingFan;
    }
    
}
