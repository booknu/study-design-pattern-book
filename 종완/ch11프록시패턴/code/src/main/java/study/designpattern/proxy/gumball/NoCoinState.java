package study.designpattern.proxy.gumball;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoCoinState implements State {
    transient private GumballMachine machine;

    /**
     * HasCoinState로 전환
     */
    @Override
    public void insertCoin() {
        int increasedCount = machine.increaseCoinCount();
        System.out.printf("동전 투입! (%d개) \n", increasedCount);
        machine.setState(machine.getHasCoinState());
    }
}
