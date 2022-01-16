package study.designpattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import study.designpattern.singleton.ChocolateBoiler;
import study.designpattern.singleton.ChocolateBoilerNotSynchronized;

public class AppTest {

    @Test
    public void singleTonTest(){
        ChocolateBoiler cb1 = ChocolateBoiler.getInstance();
        ChocolateBoiler cb2 = ChocolateBoiler.getInstance();
        ChocolateBoilerNotSynchronized cbn1 = ChocolateBoilerNotSynchronized.getInstance();
        ChocolateBoilerNotSynchronized cbn2 = ChocolateBoilerNotSynchronized.getInstance();

        assertTrue(cb1 == cb2);
        assertTrue(cbn1 == cbn2);
    }

    @Test
    public void multiThreadTest(){

        for(int i=0; i < 1000000000; i++){
            ChocolateBoilerNotSynchronized cb1 = null, 
                                            cb2 = null;
            FutureTask<ChocolateBoilerNotSynchronized> futureTask = new FutureTask<>(
                () -> ChocolateBoilerNotSynchronized.getInstance()
            );
            FutureTask<ChocolateBoilerNotSynchronized> futureTask2 = new FutureTask<>(
                () ->  ChocolateBoilerNotSynchronized.getInstance()
            );
    
            try{
                futureTask.run();
                futureTask2.run();
                cb1 = futureTask.get();
                cb2 = futureTask.get();
            }catch(ExecutionException | InterruptedException e){
                e.printStackTrace();
            }
            
            assertTrue(cb1 == cb2, (i+1) + "번째 시도에서 실패");
        }
    }

    @Test
    public void multiThreadTest2(){

        for(int i=0; i < 1000000000; i++){
            ChocolateBoiler cb1 = null,
                            cb2 = null;
            FutureTask<ChocolateBoiler> futureTask = new FutureTask<>(
                () -> ChocolateBoiler.getInstance()
            );
            FutureTask<ChocolateBoiler> futureTask2 = new FutureTask<>(
                () ->  ChocolateBoiler.getInstance()
            );
            
            try{
                futureTask.run();
                futureTask2.run();
                cb1 = futureTask.get();
                cb2 = futureTask.get();
            }catch(ExecutionException | InterruptedException e){
                e.printStackTrace();
            }
    
            
            assertTrue(cb1 == cb2, (i+1) + "번째 시도에서 실패");
        }
    }
}
