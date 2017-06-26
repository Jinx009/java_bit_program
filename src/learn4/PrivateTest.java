package learn4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateTest {


    public static void main(String[] args) throws Exception {
        Private p = new Private();

        Class<?> classType = p.getClass();

        Method method = classType.getDeclaredMethod("sayHello", new Class[]{String.class});

        method.setAccessible(true);

        String str = (String) method.invoke(p, new Object[]{"zhangsan"});

        System.out.println(str);

        System.out.println("----------------------------");

        Field field = classType.getDeclaredField("edu");

        field.setAccessible(true);

        System.out.println(p.getEdu());

        System.out.println("****************************");

        field.set(p, "lisi");

        System.out.println(p.getEdu());

        Private1 p1 = new Private1();

        Class<?> classType2 = p1.getClass();

        Class<?> classType3 = classType2.getSuperclass();

        System.out.println(classType2 + "的父类是：" + classType3);
    }
}
