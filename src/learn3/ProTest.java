package learn3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class ProTest<T extends List<ArrayList<String>>> {
    public static void main(String[] args) {
        Properties p = System.getProperties();

        Set<Object> set = p.keySet();

        for (Iterator<Object> iter = set.iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            String value = p.getProperty(key);

            System.out.println(value);
        }
        System.out.println("--------------------");
        int[] a = new int[]{1, 3, 5, 3, 7, 8};

        for (int b : a) {
            System.out.println(b);
        }
        System.out.println("***********************");

        String[] s = new String[]{"a", "f", "r", "t"};

        for (String str : s) {
            System.out.println(str);
        }
    }
}
