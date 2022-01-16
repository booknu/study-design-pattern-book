package study.designpattern.singleton;

/**
 * Thread-safe한 초콜릿 보일러
 */
public class ChocolateBoiler {
    //읽을 때 CPU 캐시가 아니라 Memory에서 읽도록 하는 volatile 키워드
    private volatile static ChocolateBoiler instance;
    private boolean empty;
    private boolean boiled;

    public static ChocolateBoiler getInstance(){
        //DCL: 이 부분만 동시에 실행이 안되도록 한다.
        if(instance == null){
            synchronized(ChocolateBoiler.class){
                if(instance == null){
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    private ChocolateBoiler(){
        empty = true;
        boiled = false;
    }

    /**
     * 초콜릿 보일러에 재료를 집어넣음
     */
    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    /**
     * 재료를 끓임
     */
    public void boil(){
        if(!isEmpty() && !isboiled()){
            boiled = true;
        }
    }

    /**
     * 끓인 재료를 다음 단계로 넘김
     */
    public void drain(){
        if(!isEmpty() && isboiled()){
            empty = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isboiled(){
        return boiled;
    }
    
}
