package study.designpattern.facade.hometheater;

public class Screen {
    private boolean isDown;

    public Screen(){
        isDown = false;
    }

    public void goDown(){
        isDown = true;
    }

    public void goUp(){
        isDown = false;
    }

    public boolean isDown(){
        return isDown;
    }
    
}
