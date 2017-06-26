package learn3;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String word : args) {
            map.put(word, (null == map.get(word) ? 1 : map.get(word) + 1));
        }
        //System.out.println(map);

        Integer i1 = 100;
        Integer i2 = 100;

        if (i1 == i2) {
            System.out.println("i1==i2");
        } else {
            System.out.println("i1!=i2");
        }

        int result = sum(1, 2, 3, 4);

        int result1 = sum(2, 4, 6, 7, 9);

        System.out.println(result);
        System.out.println(result1);
    }

    public static int sum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
