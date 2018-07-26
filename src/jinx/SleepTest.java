package jinx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepTest {


    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            executorService.execute(new SleepTest().new SleepA());
        }
        executorService.shutdown();
    }

    class SleepA implements Runnable{
        private  int a = 10;
        public void run(){
            try {
                while (a-->0){
                    System.out.println("--"+a);
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
