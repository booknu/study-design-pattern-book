package study.designpattern.command;

public interface Command<T> {

    public void execute();
    public void undo();
    public T getReceiver();
    
}
