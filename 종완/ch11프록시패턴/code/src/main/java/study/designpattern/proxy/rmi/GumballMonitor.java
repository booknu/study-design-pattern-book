package study.designpattern.proxy.rmi;

import java.rmi.RemoteException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import study.designpattern.proxy.gumball.GumballMachine;

@RequiredArgsConstructor
public class GumballMonitor {
    @NonNull private GumballMachineRemote machine;

    public void report(){
        try {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("뽑기 기계 위치: " + machine.getLocation());
            System.out.println("상품 재고: " + machine.getGumballCount());
            System.out.println("현재 상태: " + machine.getCurrentState());
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
