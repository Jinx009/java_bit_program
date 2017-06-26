package learn2;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class SetTest1 {
    public static void main(String[] args) {
        int[] a = new int[50];

        Random r = new Random();
        TreeSet<Integer> set = new TreeSet<Integer>();
//		
//		for(int i=0;i<50;i++)
//		{
//			a[i] = r.nextInt(41)+10;
//			set.add(a[i]);
//		}
        set.add(new Integer(4));
        set.add(new Integer(4));
        for (Iterator<Integer> iter = set.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
    }
}
