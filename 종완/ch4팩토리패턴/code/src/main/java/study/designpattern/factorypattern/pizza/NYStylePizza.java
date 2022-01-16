package study.designpattern.factorypattern.pizza;


public class NYStylePizza extends AbstractPizza {
    
    @Override
    public void cut() {
        System.out.println("뉴욕 스타일 피자는 8조각으로 썰립니다.");        
    }

    NYStylePizza(){
        super();
        super.name = "뉴욕 스타일 피자";
        super.dough = "크러스트 도우";
        super.sauce = "마리아나 소스";
        toppings.add("잘게 썬 레지아노 치즈");
    }
}
