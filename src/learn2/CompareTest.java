package learn2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class CompareTest {

    public static void main(String[] args) {

        TreeSet<Person> set = new TreeSet<Person>(new MyCompare());

        set.add(new Person('C'));
        set.add(new Person('a'));
        set.add(new Person('A'));
        set.add(new Person('B'));
        set.add(new Person('E'));
        set.add(new Person('f'));

        System.out.println(set);

        for (Iterator<Person> iter = set.iterator(); iter.hasNext(); ) {
            String value = iter.next().toString();

            System.out.println(value);

        }

        LinkedList<Integer> link = new LinkedList<Integer>();

        link.add(new Integer(5));
        link.add(new Integer(-5));
        link.add(new Integer(-15));
        link.add(new Integer(15));

        Comparator<Integer> c = Collections.reverseOrder();//反序方式

        Collections.sort(link, c);

        for (Iterator<Integer> iter = link.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + "   ..   ");
        }

        Collections.shuffle(link);//乱序

        for (Iterator<Integer> iter = link.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + "/");
        }

        System.out.println("\nmax:" + Collections.max(link));
        System.out.println("min:" + Collections.min(link));
    }
}

class MyCompare implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        String obj1 = o1.toString();
        String obj2 = o2.toString();

        return obj2.compareTo(obj1);
    }
}

class Person {
    char name;

    public Person(char name) {
        this.name = name;
    }

    public String toString() {
        return String.valueOf(this.name);
    }
}