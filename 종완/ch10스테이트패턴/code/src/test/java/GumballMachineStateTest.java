import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import study.designpattern.state.GumballMachine;

public class GumballMachineStateTest {

    /**
     * 동전 안넣은 상태에서 돌리면 예외가 나와야함
     */
    @Test
    public void 동전테스트(){
        //동전이 0일 경우
        GumballMachine gumballMachine = new GumballMachine(10);
        Assertions.assertThrows(UnsupportedOperationException.class,
            () -> gumballMachine.turnCrank());
        
        // 코인 1번 넣고 그 횟수를 초과해서 turnCrank()시
        gumballMachine.insertCoin();
        Assertions.assertEquals(gumballMachine.getCoinCount(), 1);
        gumballMachine.turnCrank();
        Assertions.assertThrows(UnsupportedOperationException.class,
            gumballMachine::turnCrank);
        
        //코인 여러번 넣고 그 횟수를 초과해서 turnCrank()시
        for(int i=0; i < 5; i++){
            gumballMachine.insertCoin();
        }
        for(int i=0; i < 5; i++){
            gumballMachine.turnCrank();
        }
        Assertions.assertEquals(gumballMachine.getCoinCount(), 0);
        Assertions.assertThrows(UnsupportedOperationException.class,
            gumballMachine::turnCrank);
    }

    /**
     * 보너스 테스트 :: 10번 돌리면 1개는 보너스로 나와야함
     * 12번 돌림으로써 보너스가 제대로 주어지는지, 그리고 소비가 되는지 알아본다
     */
    @Test
    public void bonusTest(){
        int coins = 20;
        GumballMachine gumballMachine = new GumballMachine(coins);
        for(int i=0; i<coins; i++){
            gumballMachine.insertCoin();
        }

        for(int i=0; i<12; i++){
            gumballMachine.turnCrank();
        }
        Assertions.assertEquals(gumballMachine.getCoinCount(), coins - 11);
    }

    /**
     * 매진 테스트
     */
    @Test
    public void 매진테스트(){
        GumballMachine gumballMachine = new GumballMachine(1);
        for(int i=0; i<2; i++){
            gumballMachine.insertCoin();
        }
        gumballMachine.turnCrank();
        Assertions.assertThrows(UnsupportedOperationException.class, gumballMachine :: turnCrank);
    }
}
