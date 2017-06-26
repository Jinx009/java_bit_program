package learn2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CompareTest1 {
    public static void main(String[] args) {
        String[] s = new String[]{"A", "C", "g", "B", "Q"};
        Collections.sort(Arrays.asList(s), new Test());

        System.out.println(s[0]);
    }
}

class Test implements Comparator<String> {

    public int compare(String o1, String o2) {
        return -1;
    }

}