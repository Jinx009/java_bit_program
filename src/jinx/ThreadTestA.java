package jinx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTestA {
    private static  int j = 1;

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<30;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    j++;
                    System.out.println(j);
                }
            }).run();
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    j++;
//                    System.out.println(j);
//                }
//            });
        }
        executorService.shutdown();
    }

}
