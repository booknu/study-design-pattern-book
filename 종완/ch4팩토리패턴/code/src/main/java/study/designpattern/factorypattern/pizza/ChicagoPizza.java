package study.designpattern.factorypattern.pizza;

public class ChicagoPizza extends AbstractPizza {

    @Override
    public void cut() {
        System.out.println("시카고 피자는 6조각으로 썰립니다.");
    }

    public ChicagoPizza(){
        super();
        super.name = "시카고 스타일 딥 디쉬 치즈 피자";
        super.dough = "더 두꺼운 크러스트 도우";
        super.sauce = "토마토 소스";
        
        toppings.add("추가 치즈");
        toppings.add("페퍼로니");
    }

    
}
