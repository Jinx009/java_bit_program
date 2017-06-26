package learn;

public class Apple extends Fruit {
    public Apple() {
        super(1);//自身没有带参数的构造方法，所以调用了父类的带参数的构造方法，依然需要写在第一行。
        System.out.println("I am Apple!");
    }

    public void eat() {
        System.out.println("apple eat!");
    }

    public void give() {
        System.out.println("Apple give!");
        super.give(1);//不是构造方法的一般方法不强调super()的位置。
    }

    public void give(int i) {
        System.out.println("apple 1 give!");
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.give();
        apple.eat();
    }
}

class Fruit {
    public Fruit(int i) {
        System.out.println("I am Fruit!");
    }

    public void eat() {
        System.out.println("Fruit eat!");
    }

    public void give(int i) {
        System.out.println("Fruit 1 give!");
    }
}