package jinx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyConditionService {

    private Lock lock = new ReentrantLock();
    public void testMethod(){
        lock.lock();
        for (int i = 0 ;i < 5;i++){
            System.out.println("ThreadName = " + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        lock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        MyConditionService service = new MyConditionService();
        new Thread(service::testMethod).start();
        new Thread(service::testMethod).start();
        new Thread(service::testMethod).start();
        new Thread(service::testMethod).start();
        new Thread(service::testMethod).start();

        Thread.sleep(1000 * 5);
    }

}
