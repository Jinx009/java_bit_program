package learn2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i <= 50; i++) {
            //System.out.println(random.nextInt(41)+10);
        }

        int[] a = new int[]{0, 4, 4, 4, 6};
        int[] count = new int[7];
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < count.length; k++) {
                if (k == a[i]) {
                    count[a[i]]++;
                }
            }
        }
        for (int j = 0; j < count.length; j++) {
            if (count[j] == 0) {
                continue;
            }
            System.out.println(count[j]);
        }

        List list = new ArrayList();

        list.add("ss");

        list.add("dd");

        Object[] s = list.toArray();

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i].toString() + "-----");
        }

        list.remove("ss");

        List li = new ArrayList();            //多态
        li.add("22");
        System.out.println(li.size());
    }


}
