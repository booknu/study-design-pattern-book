package study.designpattern.receiver;

public enum CeilingFanSpeed {
    OFF(0), LOW(1), MEDIUM(2), HIGH(3);

    private int speed;
    
    CeilingFanSpeed(int speed){
        this.speed = speed;
    }

    public int getSpeed(){
        return this.speed;
    }
}
