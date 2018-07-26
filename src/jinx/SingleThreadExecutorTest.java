package jinx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTest {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0;i<4;i++){
            ThreadTest.ThreadA thread = new  ThreadTest().new ThreadA();
            executorService.execute(thread);
        }
        System.out.println("aaa");
        executorService.shutdown();
    }
}
