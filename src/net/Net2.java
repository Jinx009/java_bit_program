package net;

public class Net2 {
    public static void main(String[] args) {
        Thread t = new MySingleton();

        Thread t1 = new MySingleton();

        t.start();
        t1.start();
    }
}

class Singleton {
    private static Singleton singleton;

    public static Singleton getInstance() {
        if (null == singleton) {
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton();
        }
        return singleton;
    }
}

class MySingleton extends Thread {
    @Override
    public void run() {
        System.out.println(Singleton.getInstance());
    }
}