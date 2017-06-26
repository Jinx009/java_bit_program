package learn7;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnotationTest {
    private String name;

    AnnotationTest(String name) {
        this.name = name;

        System.out.println("Custractor");
    }

    @Override//重写父类或接口的方法
    public String toString() {
        return this.hashCode() + "";
    }

    @SuppressWarnings("deprecation")//不建议被使用的方法
    public String getTime() {
        return new Date().toLocaleString();
    }

    @SuppressWarnings("unchecked")//不检查某个字段的警告信息
    public String getArray() {
        @SuppressWarnings("rawtypes")//不检测泛型警告

                List list = new ArrayList();

        list.set(0, "List 0");

        return list.get(0).toString();
    }

    @MyOverride("Medivh")//等同于@MyOverride
    public String toName() {
        return "Medivh";
    }

    public String getAddress() {
        return "Shanghai";
    }

    @Another(value = "Hello")
    public static void main(String[] args) throws Exception {
        AnnotationTest test = new AnnotationTest("Medivh");

        System.out.println(test.name.toString());

        System.out.println(test.toName());

        System.out.println(test.getAddress());

        System.out.println(test.getTime());
    }
}

@interface MyOverride//自定义注解,含默认参数
{
    String value() default "Medivh";
}

@interface Another//自定义注解，需要自定义参数
{
    String value();
}