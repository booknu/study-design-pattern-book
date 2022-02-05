package study.designpattern.proxy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import study.designpattern.proxy.gumball.State;

/**
 * RMI의 서비스 형식을 정의하는 인터페이스
 */
public interface GumballMachineRemote extends Remote {

    /**
     * @return 리턴 형태는 항상 primitive or Serializable
     * @throws RemoteException
     */
    int getGumballCount() throws RemoteException;

    String getLocation() throws RemoteException;

    State getCurrentState() throws RemoteException;
}
