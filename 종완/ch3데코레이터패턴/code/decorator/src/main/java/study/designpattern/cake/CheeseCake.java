package study.designpattern.cake;

/**
 * 치즈 케이크
 */
public class CheeseCake extends Cake {
    
    @Override
    public String getDescription() {
        return "치즈 " + super.getDescription();
    }

    @Override
    public int getCost() {
        return 29000;
    }

}
