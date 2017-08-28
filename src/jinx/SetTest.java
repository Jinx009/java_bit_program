package jinx;


import java.util.*;

public class SetTest {

    public static void main(String[] argd){
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("d");
        hashSet.add("c");
        hashSet.add("z");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---------------------------------------");
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("d");
        treeSet.add("c");
        treeSet.add("z");
        Iterator<String> iterator1 = hashSet.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("---------------------------------------");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("d");
        linkedHashSet.add("c");
        linkedHashSet.add("z");
        Iterator<String> iterator2 = hashSet.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

}
