package study.designpattern.command;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import study.designpattern.receiver.CeilingFan;
import study.designpattern.receiver.CeilingFanSpeed;

@RequiredArgsConstructor
public class CeilingFanOff implements Command<CeilingFan> {
    @NonNull private CeilingFan ceilingFan;
    private CeilingFanSpeed prevStatus;

    @Override
    public void execute() {
        prevStatus = ceilingFan.getSpped();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.setSpped(prevStatus);
    }

    @Override
    public CeilingFan getReceiver() {
        return ceilingFan;
    }
    
}
