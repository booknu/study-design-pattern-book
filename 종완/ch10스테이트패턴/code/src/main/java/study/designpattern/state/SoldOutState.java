package study.designpattern.state;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SoldOutState implements State{
    private GumballMachine machine;

    @Override
    public void insertCoin() {
        System.err.println("이미 다 팔렸습니다...");
    }

    @Override
    public void ejectCoin() {
        int count = machine.getCoinCount();
        if(count > 0){
            count = machine.decreaseCoinCount();
            System.out.printf("동전을 돌려드립니다. (남은 동전 수: %d)\n", count);
            machine.decreaseCoinCount();
        }else{
            System.err.println("동전이 없습니다!");
        }
    }

}
