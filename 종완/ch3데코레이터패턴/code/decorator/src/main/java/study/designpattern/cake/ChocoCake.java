package study.designpattern.cake;

public class ChocoCake extends Cake {
    @Override
    public String getDescription() {
        return "초코" + super.getDescription();
    }

    @Override
    public int getCost() {
        return 27000;
    }
    
}
