package learn2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("a", "b");
        map.put("c", "b");
        map.put("a", "d");
        map.put("d", "b");
        map.put("e", "d");

        System.out.println(map.size());
        System.out.println(map);

        Set set = map.keySet();
        Set set1 = (Set) map.entrySet();

        for (Iterator<String> iter = set.iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            String value = (String) map.get(key);
            System.out.println(key + ":" + value);
        }
        System.out.println("*******************");

        for (Iterator<Entry> iter = set1.iterator(); iter.hasNext(); ) {
            Entry en = iter.next();

            System.out.println(en.getValue() + ":" + en.getKey());
        }
    }
}
