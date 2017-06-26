package learn12;

public class MemInnerClass {
    public static void main(String[] args) {
        Test.MemInner mem = new Test().new MemInner();

        mem.print();

    }
}

/*
 * 成员内部类
 */
class Test {
    private int a = 4;

    public class MemInner {
        private int a = 5;

        public void print() {
            System.out.println("Test.a=" + Test.this.a);

            System.out.println("MemInner.a=" + this.a);
        }
    }
}