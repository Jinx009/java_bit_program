package jinx;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PriorityTest {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<3;i++){
            executorService.execute(new PriorityTest().new PriorityA(3));
        }
        executorService.execute(new PriorityTest().new PriorityA(5));
        executorService.shutdown();
    }


    class PriorityA implements Runnable{
        private int priority;
        public PriorityA(int priority){
            this.priority = priority;
        }
        public void run(){
            Thread.currentThread().setPriority(priority);
            for(int i = 0;i<5000000;i++){
                double b = 10000*22200*Math.PI;
//                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+priority);
        }
    }


}
