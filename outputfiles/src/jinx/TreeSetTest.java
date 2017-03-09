package jinx;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by jinx on 10/12/16.
 */
public class TreeSetTest {

    public static void main(String[] args){
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("招商银行");
        treeSet.add("浦发银行");
        treeSet.add("华夏银行");


        Iterator it = treeSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next()+",");
        }
    }

}
