package study.designpattern.command;

public class NoCommand implements Command<String>{

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
        
    }

    @Override
    public String getReceiver() {
        return "명령어 없음";
    }
    
}
