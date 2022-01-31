import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import study.designpattern.proxy.gumball.GumballMachine;
import study.designpattern.proxy.rmi.GumballMachineRemote;
import study.designpattern.proxy.rmi.GumballMonitor;

public class RMITest {

    @Test
    public void 모니터링_테스트(){
        try {
            GumballMachineRemote remoteMachine
                = (GumballMachineRemote) Naming.lookup("rmi://127.0.0.1/남양주_기계");

            System.out.println("남양주에 있는 Remote Object로부터 불러오기!");
            System.out.println("기계 위치: " +remoteMachine.getLocation());
            System.out.println("재고: " + remoteMachine.getGumballCount());
            System.out.println("현재 상태: " + remoteMachine.getCurrentState().getClass().getSimpleName());

        }catch (MalformedURLException| NotBoundException | RemoteException e){
            e.printStackTrace();
        }
    }
}
