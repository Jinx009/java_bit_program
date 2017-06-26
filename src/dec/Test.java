package dec;

public class Test {
    public static void main(String[] args) {
        Mum t = new Son();

        t.doSomething();

        System.out.println("*******************************");

        Mum a = new A(new Son());

        a.doSomething();

        System.out.println("*******************************");

        Mum a1 = new A1(new Son());

        a1.doSomething();

        System.out.println("*******************************");

        Mum a2 = new A2(new Son());

        a2.doSomething();

        System.out.println("*******************************");

        Mum m1 = new A2(new A1(new Son()));

        m1.doSomething();

        System.out.println("*******************************");

        Mum m2 = new A1(new A2(new Son()));

        m2.doSomething();
    }
}
