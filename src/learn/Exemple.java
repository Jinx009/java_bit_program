package learn;

public class Exemple {
    public static void test(A a) {
        a.test();
    }

    public static void main(String[] args) {
        A a = new B();
        test(a);
    }
}

class A {
    public void test() {
        System.out.println("A");
    }
}

class B extends A {
    public void test() {
        System.out.println("B");
    }
}

class C extends A {
    public void test() {
        System.out.println("C");
    }
}