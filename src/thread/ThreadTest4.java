package thread;

public class ThreadTest4 {
    public static void main(String[] args) {
        A a = new A();

        Thread t1 = new A1(a);

        //a = new A();

        Thread t2 = new A2(a);

        t1.start();

        t2.start();
    }
}

class A {
    public synchronized static void test() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("A1: " + i);
        }
    }

    public synchronized static void test2() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("A2: " + i);
        }
    }
}


class A1 extends Thread {
    private A a;

    public A1(A a) {
        this.a = a;
    }

    public void run() {
        A.test();//this.a.test();
    }
}

class A2 extends Thread {
    private A a;

    public A2(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        A.test2();//this.a.test2();
    }
}


