package learn1;

public class Singleton {
    public static void main(String[] args) {
        SingletonTest test = SingletonTest.getSingleton();

        SingletonTest test1 = SingletonTest.getSingleton();

        boolean result = (test1 == test);

        boolean result1 = (test1.equals(test));

        System.out.println(result);

        System.out.println(result1);

        SingletonTest t = SingletonTest.getInstance();

        SingletonTest t1 = SingletonTest.getInstance();

        boolean r = (t == t1);

        boolean r1 = (t.equals(t1));

        System.out.println(r);

        System.out.println(r1);
    }
}

class SingletonTest {
    /*
     * 单类模式，单态模式
     */
    private static SingletonTest test = new SingletonTest();

    private static SingletonTest test1;

    private SingletonTest() {

    }

    public static SingletonTest getSingleton() {
        return test;
    }

    public static SingletonTest getInstance() {
        if (test1 == null) {
            test1 = new SingletonTest();
        }
        return test1;
    }
}