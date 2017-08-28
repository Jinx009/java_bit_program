package jinx;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Test_1 {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> list3 = new ArrayList<String>();
        list.add("asa1ad");
        list.add("asaasa2");
        System.out.println(JSON.toJSON(list));
        Map<String,String> data = new HashMap<String,String>();
        for(String i : list){
            data.put(i,i);
        }
        System.out.println(JSON.toJSON(data));
        Iterator it = data.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            list2.add(data.get(key));
        }
        System.out.println(JSON.toJSON(list2));
        for(String s :list2){
            list3.add(s);
        }
        System.out.println(JSON.toJSON(list3));
    }



}
