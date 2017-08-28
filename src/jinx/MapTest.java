package jinx;


import java.util.*;

public class MapTest {

    public static void main(String[] args){
        TreeMap<String,String> treeMap = new TreeMap<String,String>();
        treeMap.put("c","c_v");
        treeMap.put("b","b_v");
        treeMap.put("z","z_v");
        Set<Map.Entry<String, String>> set = treeMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> mEntry = iterator.next();
            System.out.println(mEntry.getKey()+"="+mEntry.getValue());
        }
        System.out.println("---------------------------------------");
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>();
        linkedHashMap.put("c","c_v");
        linkedHashMap.put("b","b_v");
        linkedHashMap.put("z","z_v");
        Set<Map.Entry<String, String>> set1 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String, String> mEntry = iterator1.next();
            System.out.println(mEntry.getKey()+"="+mEntry.getValue());
        }
        System.out.println("---------------------------------------");
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("c","c_v");
        hashMap.put("b","b_v");
        hashMap.put("z","z_v");
        Set<Map.Entry<String, String>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
        while(iterator2.hasNext()){
            Map.Entry<String, String> mEntry = iterator2.next();
            System.out.println(mEntry.getKey()+"="+mEntry.getValue());
        }
    }

}
