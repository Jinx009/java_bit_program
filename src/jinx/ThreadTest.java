package jinx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<4;i++){
            ThreadTest.ThreadA thread = new  ThreadTest().new ThreadA();
            executorService.execute(thread);
        }
        System.out.println("aaa");
        executorService.shutdown();
    }


    class ThreadA implements  Runnable{
        public void run(){
            for(int i = 0;i<22;i++){
                System.out.println(Thread.currentThread()+"--"+i);
            }
            System.out.println("sss");
        }
    }

}

