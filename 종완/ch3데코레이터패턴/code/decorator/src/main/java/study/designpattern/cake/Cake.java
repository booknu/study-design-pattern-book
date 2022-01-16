package study.designpattern.cake;

/**
 * 장식당할(?) 클래스
 */
public abstract class Cake {
    private String description = "케이크";

    public String getDescription() {
        return description;
    }
    
    abstract public int getCost();

    @Override
    public String toString() {
        return getDescription();
    }
}
