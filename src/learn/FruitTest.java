package learn;

public class FruitTest extends Plant {
    public void giveName() {
        System.out.println("FruitTest");
    }

    public static void main(String[] args) {
        args = new String[]{"0", "1"};

        Plant plant = new Plant();
        plant.giveName();
        plant.printName();

        Plant plant1 = new FruitTest();//父类的引用可以指向子类的对象，那么就可以称之为多态
        FruitTest t = (FruitTest) plant1;//plant1引用指向了一个FruitTest对象，所以可以将一个FruitTest对象的引用t指向plant1；向下强制类型转换。有约束条件。
        t.giveName();

        VegetablesTest v = new VegetablesTest();
        Plant p = v;//向上强制类型转换，因为v引用指向了一个VegetablesTest对象，VegetablesTest类继承于Plant类，所以Plant对象的引用p可以指向v；
        p.giveName();

        Plant p1 = null;
        if ("0".equals(args[0])) {
            p1 = new FruitTest();
        } else if ("1".equals(args[0])) {
            p1 = new VegetablesTest();
        }
        p1.giveName();
    }
}

class Plant {
    public void giveName() {
        System.out.println("plant");
    }

    public void printName() {
        System.out.println("print");
    }
}

class VegetablesTest extends Plant {
    public void giveName() {
        System.out.println("Vegetables");
    }
}
