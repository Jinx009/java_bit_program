package thread;

public class ThreadTest3 {
    public static void main(String[] args) {
        Runnable f = new First();

        Thread t = new Thread(f);

        Thread t1 = new Thread(f);

        t.start();

        t1.start();
    }
}

class First implements Runnable {
    int i;

    public void run() {
        int i = 0;

        while (true) {
            System.out.println("First" + i++);
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (10 == i) {
                break;
            }
        }
    }
}