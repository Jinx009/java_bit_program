package learn12;

/*
 * 静态内部类
 */
public class InnerClassTest {
    public static void main(String[] args) {
        InnerClass.InnerClass1 i1 = new InnerClass.InnerClass1();

        i1.printA();
    }

    public static class Inner {

    }
}

class InnerClass {
    public static int a = 4;

    public static class InnerClass1 {
        public void printA() {
            System.out.println(a);
        }
    }
}