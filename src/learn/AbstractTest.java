package learn;

public class AbstractTest extends Abstract {

    int width;

    int height;

    public AbstractTest(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void printName()//继承了抽象类的类，它必须实现抽象类的抽象方法；具体方法可以不实现；
    {
        System.out.println("继承后的抽象方法");
    }

    public int getArea() {
        int area = width * height;
        return area;
    }

    public int getArea(int i, int y) {
        return i * y;

    }

    public static void main(String[] args) {
        //Abstract a = new Abstract(); 不允许的操作，因为抽象类如果重写抽象方法的话，那么该抽象类无法被实例化；Cannot instantiate the type Abstract
        /*
		 * 修改了原抽象类的抽象方法为不抽象，可以被实例化；
		 */
        Abstract a = new Abstract() {
            public void printName() {
                System.out.println("已经不是抽象方法了");
            }

            public int getArea() {
                return 0;
            }
        };
        a.printAge();
		/*
		 * 它的子类可以实例化；
		 */
        AbstractTest at = new AbstractTest(4, 5);

        at.printName();

        System.out.println(at.getArea());
    }
}
