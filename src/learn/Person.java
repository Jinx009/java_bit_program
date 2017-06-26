package learn;

public class Person {

    static int one;

    int two;

    public static void run(int speed)//定义一个静态的方法，可以称作为动作。void代表不返回值， run代表方法名称，int 代表参数类型，speed代表参数名称
    {
        System.out.println("run with : " + speed);
        return;//可以不用，但是return后必须直接加分号，代表跳到方法头，不返回值；
    }

    public int getMoney(int money)//定义一个普通的方法，可以称作为动作。
    {
        return money;
    }

    public static void main(String[] args) {

        int x = 100;//类的关键一部分,属性也可以成为成员变量。

        Person person = new Person();//生成Person的一个对象（实例），这个过程又叫实例化。其中真正的对象是new Person(),而person只是一个引用，它负责指向new Person()这个对象。

        int getMoney = person.getMoney(x);//调用新生成的Person类的一个对象person的getMoney方法；

        System.out.println("peroson   getMoney  : " + getMoney);

        int a = 300;//类的关键一部分,属性也可以成为成员变量。300是实际参数，300赋值给a，a是形式参数。

        run(a);//不生成对象，直接调用类的静态方法;

        run(one);//如果一个成员变量没有初始化，那么你可以以成员变量的形式调用它，如run(person.two),否则就只能调用静态的变量。

        run(person.two);

        run(Person.one);//等同上面run(one)，

        //run(300,500);果断不行与run方法中的参数个数不同。

        //run("300km");依然不行"300km"是字符串，与run方法中的参数类型不同。

        Person.run(x);//等同于run(x);
    }
}
