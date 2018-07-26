package jinx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {

    private static  int a = 1;


    public  synchronized int add(){
        return ++a;
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
//            System.out.println(add());
            executorService.execute(new SynchronizedTest().new AAAAA());
        }
        executorService.shutdown();
    }

    class AAAAA implements Runnable{
        public void run(){
            System.out.println(add());
        }
    }

}
