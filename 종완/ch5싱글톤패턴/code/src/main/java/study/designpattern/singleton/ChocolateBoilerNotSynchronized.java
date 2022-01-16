package study.designpattern.singleton;

/**
 * Thread-safe 하지 않은 초콜릿 보일러
 */
public class ChocolateBoilerNotSynchronized {
    private static ChocolateBoilerNotSynchronized instance;
    private boolean empty;
    private boolean boiled;

    public static ChocolateBoilerNotSynchronized getInstance(){
        if(instance == null){
            instance = new ChocolateBoilerNotSynchronized();
        }
        return instance;
    }

    private ChocolateBoilerNotSynchronized(){
        empty = true;
        boiled = false;
    }
    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void boil(){
        if(!isEmpty() && !isboiled()){
            boiled = true;
        }
    }

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
