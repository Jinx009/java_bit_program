package jinx;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

    public static void main(String[] args) throws Exception{
        System.out.println(new CallableTest().new CallableA().call());
        ArrayList<Future<String>> arrs = new ArrayList<Future<String>>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            arrs.add(executorService.submit(new CallableTest().new CallableB()));
        }
        executorService.shutdown();
//        System.out.println(arrs);
        for(Future<String> str : arrs){
            System.out.println(str.get());
        }
    }
    class CallableA implements Callable<String>{
        public String call(){
            int i = 0;
            for(int j = 0;j<100;j++){
                i++;
            }
            return String.valueOf(i);
        }
    }
    class CallableB implements Callable<String>{
        public String call(){
            return "aaaaa";
        }
    }
}
