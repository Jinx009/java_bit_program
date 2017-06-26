package thread;

public class TreadTest {
    public static void main(String[] args) {
        Testt t = new Testt();

        Test2 t1 = new Test2();

        Test3 t2 = new Test3();

        //t.start();

        t1.start();

        t2.start();
    }
}

class Test extends Thread {
    public void run() {
        System.out.println("-------------------------------------1");
    }
}

class Test2 extends Thread {
    public void run() {
        System.out.println("*************************************2");
    }
}

class Test3 extends Thread {
    public void run() {
        System.out.println("++++++++++++++++++++3");
    }
}
