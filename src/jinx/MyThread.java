package jinx;

/**
 * Created by jinx on 6/12/17.
 */
public class MyThread {

    public static void main(String[] args){
        new ThreadA().start();
        new ThreadB().start();
    }

}
class ThreadA extends Thread{
    public void run(){
        System.out.print("I am Thread A");
    }
}
class ThreadB extends Thread{
    public void run(){
        System.out.print("I am Thread B");
    }
}
