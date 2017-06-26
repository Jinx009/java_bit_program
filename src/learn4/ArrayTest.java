package learn4;

import java.lang.reflect.Array;

public class ArrayTest {
    public static void main(String[] args) {
        int[] dims = {1, 4, 6};

        Object obj = Array.newInstance(Integer.TYPE, dims);

        System.out.println(obj instanceof int[][][]);

        Object arr = Array.get(obj, 3);

        //Class<?> classType = obj.getClass().getComponentType();

        arr = Array.get(arr, 5);

        Array.set(arr, 10, 37);
//			
//			int [][][] arr_int = (int [][][]) arr;
//			
//			System.out.println(arr_int);
    }
}
