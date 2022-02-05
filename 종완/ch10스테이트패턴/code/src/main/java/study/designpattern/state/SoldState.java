package study.designpattern.state;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SoldState implements State {
    private GumballMachine machine;

    /**
     * 알맹이 내뱉고 SoldoutState로 갈 지 CoinState로 갈 지 결정
     */
    @Override
    public void dispense() {
        machine.releaseBall();

        if(machine.getGumballCount() == 0){
            machine.setState(machine.getSoldOutState());
        }else if(machine.getWinnerBonusCount() >= GumballMachine.WINNER_COUNT){
            machine.setWinnerBonusCount(0);
            System.out.println("보너스 당첨! 한번 더 돌리세요");
            machine.setState(machine.getWinnerState());

        }else if(machine.getCoinCount() == 0){
            machine.setState(machine.getNoCoinState());
        }else{
            machine.setState(machine.getHasCoinState());
        }
    }
}
