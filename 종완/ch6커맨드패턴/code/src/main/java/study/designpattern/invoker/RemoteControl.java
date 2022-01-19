package study.designpattern.invoker;

import java.util.ArrayList;
import java.util.List;

import study.designpattern.command.Command;
import study.designpattern.command.NoCommand;

public class RemoteControl {
    private List<Command<?>> onCommands;
    private List<Command<?>> offCommands;
    private Command<?> recentCommand; //실행취소를 여러번 할 수 있는 것도 해보려 했으나 시간 관계상 PASS
    private static Command<?> noCommand = new NoCommand();
    private static final int INIT_SIZE = 7;
    
    @SuppressWarnings("rawtype")
    public RemoteControl(){
        onCommands = new ArrayList<>();
        offCommands = new ArrayList<>();
        ((ArrayList)onCommands).ensureCapacity(INIT_SIZE);
        ((ArrayList)offCommands).ensureCapacity(INIT_SIZE);
        for(int i=0; i<INIT_SIZE; i++){
            onCommands.add(new NoCommand());
            offCommands.add(new NoCommand());
        }
    }

    public void setCommand(int idx, Command<?> onCommand, Command<?> offCommand){
        onCommands.set(idx, onCommand);
        offCommands.set(idx, offCommand);
    }

    public void pushOnButton(int idx){
        Command<?> onCommand = onCommands.get(idx);
        recentCommand = onCommand;
        onCommand.execute();
    }
    
    public void pushOffButton(int idx){
        Command<?> offCommand = offCommands.get(idx);
        recentCommand = offCommand;
        offCommand.execute();
    }

    public void undo(){
        recentCommand.undo();
        recentCommand = noCommand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================리모컨=================");
        sb.append("리시버, Command(on), Command(off)");
        
        final int size = onCommands.size();
        for(int i=0; i < size; i++){
            final var on = onCommands.get(i);
            final var off = offCommands.get(i);
            sb.append(i+1 + ":  ");
            sb.append(on.getReceiver().getClass().getSimpleName() + " / ");
            sb.append(on.getClass().getSimpleName() + " / ");
            sb.append(off.getClass().getSimpleName() + " / ");
        }
        return sb.toString();
    }
}
