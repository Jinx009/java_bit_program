package learn2;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ListTest

{
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 5000; i++) {
            list.add("Test" + i);
        }
        System.out.println("ArrayList查找最后一个元素耗时：" + timeList(list, "Test4999"));

        List<String> list1 = new LinkedList<String>();

        for (int i = 0; i < 5000; i++) {
            list1.add("Error" + i);
        }
        System.out.println("LinkedList查找最后一个元素耗时：" + timeList(list1, "Error4999"));
    }

    static long timeList(List<String> lst, String str) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 5000; i++)

        {
            Collections.binarySearch(lst, str);
        }
        return System.currentTimeMillis() - start;
    }
} 
