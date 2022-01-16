package study.designpattern.factorypattern.pizza;

import java.util.ArrayList;

/**
 * 추상 피자 클래스.
 */
public abstract class AbstractPizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();
    private Status status;
    
    
    public void prepare(){
        System.out.println("피자 준비중: " + this.name);
        System.out.println("도우 펴는 중");
        System.out.println("소스 바르는 중");
        System.out.println("토핑 준비 중");
        
        String last = toppings.get(toppings.size() - 1);
        toppings.forEach(topping -> {
            System.out.print(topping);
            if(!topping.equals(last)) System.out.print(", ");
        });
        this.status = Status.PREPARED;
    }

    public void bake(){
        System.out.println("피자 굽는 중");
        this.status = Status.BAKED;
    }

    public void cut(){
        System.out.println("피자 조각내는 중");
        this.status = Status.CUT;
    }

    public void box(){
        System.out.println("피자가 포장되었습니다.");
        this.status = Status.BOXED;
    }

    public Status getStatus(){
        return this.status;
    }
    
    enum Status{
        PREPARED, BAKED, CUT, BOXED;
    }
}
