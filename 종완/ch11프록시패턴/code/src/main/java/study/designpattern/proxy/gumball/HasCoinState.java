package study.designpattern.proxy.gumball;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HasCoinState implements State{
    transient private GumballMachine machine;

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
        if(machine.getCoinCount() == 0) machine.setState(machine.getNoCoinState());
    }

    /**
     * SoldState로 전환
     */
    @Override
    public void turnCrank() {
        machine.decreaseCoinCount();
        machine.setState(machine.getSoldState());
    }
}
