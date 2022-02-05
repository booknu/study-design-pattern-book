package study.designpattern.proxy.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import study.designpattern.proxy.gumball.GumballMachine;

public class RMIRegistry {

    /**
     * 터미널에서 rmiregistry 실행 후 실행 (서버 역할)
     * @param args
     */
    public static void main(String[] args) {
        final String location = "경기도 남양주시";
        final int gumballCount = 123;
        try{
            GumballMachineRemote gumballMachine =
                new GumballMachine(location, gumballCount);

            Naming.rebind("남양주_기계", gumballMachine);

            System.out.println("");
        }catch (MalformedURLException |RemoteException e){
            System.err.println("====RemoteException 발생====");
            e.printStackTrace();
        }
    }
}
