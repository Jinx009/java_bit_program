package jinx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTestA implements Runnable {

    public int value = 1;

    public int getValue(){
        return value;
    }

    private synchronized  void add(){
        value++;
        value++;
    }

    public void run(){
        while (true){
            add();
        }
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedTestA synchronizedTestA = new SynchronizedTestA();
        executorService.execute(synchronizedTestA);
        while (true){
            int a = synchronizedTestA.getValue();
            if(a%2!=0){
                System.out.println("---"+a);
                System.exit(0);
            }
        }
//        executorService.shutdown();
    }

}
