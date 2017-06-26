package learn1;

public class InstanceOf {
    public static void main(String[] args) {
        InstanceOf io = new InstanceOf();

        boolean b = io instanceof InstanceOf;

        System.out.println(b);

        Stu stu = new Stu();

        System.out.println(stu.toString());
    }
}

class Stu extends Object {
    public String toString() {
        return "hello";
    }
}
