package study.designpattern.state;

import lombok.AllArgsConstructor;

/**
 * HasCoinState랑 다를 바가 없다.
 */
@AllArgsConstructor
public class WinnerState implements State{
    private GumballMachine machine;

    @Override
    public void insertCoin() {
        int increasedCount = machine.increaseCoinCount();
        System.out.printf("동전 투입! (%d개) \n", increasedCount);
    }

    /**
     * 동전을 뱉고 NoCoinState로 전환해야할것이다
     */
    @Override
    public void ejectCoin() {
        System.err.println("퉤");
        machine.decreaseCoinCount();
    }

    /**
     * (무시)
     */
    @Override
    public void turnCrank() {

        machine.setState(machine.getSoldState());
    }

}
