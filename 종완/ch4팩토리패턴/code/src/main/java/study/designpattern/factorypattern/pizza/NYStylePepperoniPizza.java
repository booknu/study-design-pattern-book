package study.designpattern.factorypattern.pizza;

/**
 * 이런 식으로 클래스 만드는 것은 자제해야 한다.
 * 구상 클래스인 NYStylePizza가 바뀌면 참사가 일어나니까
 */
public class NYStylePepperoniPizza extends NYStylePizza {

    public NYStylePepperoniPizza(){
        super();
        super.name = "뉴욕 스타일 '페퍼로나' 피자";
        toppings.add("페퍼로니");
    }
    
}
