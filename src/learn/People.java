package learn;

public class People {
    static int age;

    int height;

    public int change(int age) {
        People.age = age;

        return People.age;
    }

    public int change1(int height) {
        People p = new People();

        p.height = height;//不是静态变量，只影响本对象的成员变量

        p.age = 22;//静态变量修改后影响全局

        return p.height;

    }

    public static void main(String[] args) {
        System.out.println(People.age);

        People p = new People();

        System.out.println(p.age);

        int height1 = p.change(25);

        System.out.println(height1);

        System.out.println(p.height);

        System.out.println(p.age);

        People p1 = new People();

        int height2 = p1.change1(20);

        System.out.println(height2);

        System.out.println(p1.height);

        System.out.println(p1.age);

    }
}
