package learn1;

public class InterTest extends InterTester {
    public static void main(String[] args) {
        IInterTest test = new InterTest();//接口的多态，借口自己无法实例化，但是它的引用可以指向它的一个实现类的对象；

        test.printName();

        InterTester test1 = new InterTest();

        InterTester test2 = new InterTest();

        test1.printAge();//父类的static方法是无法被重写的，就是你写了它也不帮子类实现，一直实现的是父类的方法；

        InterTester.printAge();//推荐使用类名.加静态方法
    }

    public void printName()//抽象类实现接口，可以不写接口中的方法，但是不代表它没做；实现接口的抽象类中虽然可以不写接口的方法，但是不代表这个方法没有，所以必须实现抽象方法；
    {
        System.out.println("MyName");
    }

    public static void printAge() {
        System.out.println(33);
    }

    public InterTest()//只在new一个新的对象的时候，才执行构造方法；
    {
        System.out.println("后于静态代码块执行！");
    }

    static //初始时执行，执行一次，最先执行最上级的父类，再依次向下执行，执行完所有静态代码块再做其他操作；
    {
        System.out.println("静态代码块，先于构造方法！");
    }
}

abstract class InterTester implements IInterTest {
    //抽象类实现接口，可以不写接口中的方法，但是不代表它没做；


    public static void printAge() {
        System.out.println(23);
    }
}