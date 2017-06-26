package learn2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("b");

        String s = new String("e");
        String s1 = new String("e");

        set.add(s1);
        set.add(s);

        System.out.println(set);

        SetTest test = new SetTest();

        SetTest test1 = new SetTest();

        System.out.println(test.hashCode());

        System.out.println(test1.hashCode());

        Iterator<String> iter = set.iterator();

        while (iter.hasNext()) {
            String value = (String) iter.next();

            System.out.print(value + ",");
        }

        TreeSet<String> tree = new TreeSet<String>();

        tree.add("D");
        tree.add("A");
        tree.add("C");
        tree.add("E");

        System.out.println("\n" + tree);
    }
}
