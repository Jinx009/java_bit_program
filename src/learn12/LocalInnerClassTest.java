package learn12;

public class LocalInnerClassTest {
    public static void main(String[] args) {
        LocalInner l = new LocalInner();

        l.print();
    }
}

/*
 * 方法内部类
 */
class LocalInner {
    public void print() {
        final int a = 4;
        class Inner {
            void print() {
                System.out.println(a);//只能调用final成员变量
            }
        }
        new Inner().print();
    }
}