package thread;

public class ThreadTest2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Tes());

        Thread t1 = new Thread(new Tes2());

        t.start();

        t1.start();

        t.setName("这是个线程");

        System.out.println(t.getName());

        System.out.println(t1.getName());
    }
}

class Tes implements Runnable {

    public void run() {
        System.out.println("------------------------------1");
    }

}

class Tes2 implements Runnable {

    @Override
    public void run() {
        System.out.println("_++++++++++++++++++++++=2");
    }

}
