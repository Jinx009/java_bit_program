package jinx;


import java.util.*;

public class ListTest {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("n");
        list.add("m");
        list.add("y");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("--------------------");
        List<String> list1 = new LinkedList<String>();
        list1.add("n");
        list1.add("m");
        list1.add("y");
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("--------------------");
        Collections.sort(list);
        Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

}
