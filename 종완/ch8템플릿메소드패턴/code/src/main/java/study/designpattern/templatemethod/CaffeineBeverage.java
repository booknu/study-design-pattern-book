package study.designpattern.templatemethod;

public abstract class CaffeineBeverage {

    /**
     * 텝플릿 메소드 :: 어떤 알고리즘들(차 끓이는 과정)에 대한 틀 역할을 한다.
     */
    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 차 또는 커피콩을 우려내기
     */
    abstract void brew();

    /**
     * 첨가물 추가
     */
    abstract void addCondiments();

    /**
     * 후크 메소드 :: 서브클래스에서 필요에 따라서 알고리즘의 실행 흐름을 바꿀 수 있다.
     */
    boolean customerWantsCondiments(){
        return true;
    }

    /**
     * 물 끓이기
     */
    void boilWater(){
        System.out.println("물을 끓이고 있음");
    }

    /**
     * 컵에 따르기
     */
    void pourInCup(){
        System.out.println("컵에 따르고 있음");
    }
}
