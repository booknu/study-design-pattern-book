package study.designpattern.proxy.gumball;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lombok.Getter;
import lombok.Setter;
import study.designpattern.proxy.rmi.GumballMachineRemote;

public class GumballMachine extends UnicastRemoteObject  implements GumballMachineRemote {
    @Getter private State noCoinState, hasCoinState, soldState, soldOutState, winnerState, currentState;
    @Getter private int gumballCount = 0, coinCount = 0;
    @Getter @Setter private int winnerBonusCount = 0;
    @Getter @Setter private String location;
    static final int WINNER_COUNT = 10;

    {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);
    }

    public GumballMachine(String location, int gumballCount) throws RemoteException {
        super();
        this.gumballCount = gumballCount;
        this.location = location;

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
