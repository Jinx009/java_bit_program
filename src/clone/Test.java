package clone;

public class Test {
    public static void main(String[] args) throws Throwable {
        CloneTest c = new CloneTest();

        c.setAge(3);
        c.setName("张三");

        CloneTest c1 = (CloneTest) c.clone();

        System.out.println(c1.equals(c));

        System.out.println(c1.getAge());

        System.out.println(c1.getName());
    }
}

class CloneTest implements Cloneable {
    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}