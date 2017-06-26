package learn4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ClassTest test = new ClassTest();

        System.out.println(test.getClass());

        System.out.println(test.getClass().getName());

        System.out.println(test.getClass().getConstructor());

        Class<?> classType = Cont.class;

        Cont con1 = new Cont();

        Class<?> classType1 = con1.getClass();

        Constructor<?> con = classType.getConstructor(new Class[]{String.class});

        Object obj = con.newInstance("Name");

        System.out.println(obj);

        Field[] f = classType1.getDeclaredFields();

        System.out.println(f);
    }
}

class Cont {
    String id;

    public Cont() {

    }

    public Cont(String id) {
        this.id = id;
    }

}