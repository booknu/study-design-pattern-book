package study.designpattern.cake;

public class CreamCake extends Cake {
    @Override
    public String getDescription() {
        return "크림" + super.getDescription();
    }
    @Override
    public int getCost() {
        return 40000;
    }

    
}
