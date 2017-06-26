package learn;

public abstract class Abstract//定义一个抽象类
{
    public abstract void printName();//只有抽象类才有权利拥有抽象方法；

    public abstract int getArea();

    public void printAge()//抽象类也可以拥有具体的方法；
    {
        System.out.println(23);
    }

}
