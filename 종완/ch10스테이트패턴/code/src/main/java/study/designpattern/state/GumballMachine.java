package study.designpattern.state;

import lombok.Getter;
import lombok.Setter;

public class GumballMachine {
    @Getter private State noCoinState, hasCoinState, soldState, soldOutState, winnerState;
    private State currentState;
    @Getter private int gumballCount = 0, coinCount = 0;
    @Getter @Setter private int winnerBonusCount = 0;
    static final int WINNER_COUNT = 10;

    {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);
    }

    public GumballMachine(int gumballCount){
        this.gumballCount = gumballCount;

        //예외적으로 생성자에서만 상태에 관한 설정을 한다.
        if(gumballCount > 0){
            currentState = noCoinState;
        }else{
            currentState = soldOutState;
        }
    }

    public void insertCoin(){
        currentState.insertCoin();
    }

    public void ejectCoin(){
        currentState.ejectCoin();
    }

    public void turnCrank(){
        currentState.turnCrank();
        currentState.dispense();
    }

    void setState(State state){
        this.currentState = state;
    }

    /**
     * 동전을 넣고 증가한 값을 반환합니다
     * @return 증가한 값
     */
    int increaseCoinCount(){
        return ++coinCount;
    }

    /**
     * 동전을 꺼내고 감소한 값을 반환합니다
     * @return 감소한 값
     */
    int decreaseCoinCount(){
        return --coinCount;
    }

    void releaseBall(){
        System.out.println("기계에서 뭔가가 나옵니다....");
        gumballCount--;
        winnerBonusCount ++;
    }
}
