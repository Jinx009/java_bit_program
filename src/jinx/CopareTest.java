package jinx;
import java.util.ArrayList;
import java.util.List;

public class CopareTest {

    private static ArrayList<Integer> tmpArr = new ArrayList<>();
    public static void main(String[] args) {
        int [] com = {1,2,3,4};
        int k = 4;
        if(k > com.length || com.length <= 0){
            return ;
        }
//        System.out.println("组合结果：");
//        combine(0 ,k ,com);
//        System.out.println("\n排列结果：");
//        arrangement(k,com);
        System.out.println("\n可重复排列结果：");
        repeatableArrangement(k, com);
    }

    /**
     * 组合
     * 按一定的顺序取出元素，就是组合,元素个数[C arr.len 3]
     * @param index 元素位置
     * @param k 选取的元素个数
     * @param arr 数组
     */
    public static void combine(int index,int k,int []arr) {
        if(k == 1){
            for (int i = index; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                System.out.print(tmpArr.toString() + ",");
                tmpArr.remove((Object)arr[i]);
            }
        }else if(k > 1){
            for (int i = index; i <= arr.length - k; i++) {
                tmpArr.add(arr[i]); //tmpArr都是临时性存储一下
                combine(i + 1,k - 1, arr); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove((Object)arr[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        }else{
            return ;
        }
    }

    /**
     * 排列
     * 按照无序（随机）的方式取出元素，就是排列,元素个数[A arr.len 3]
     * @param k 选取的元素个数
     * @param arr 数组
     */
    public static void arrangement(int k,int []arr){
        if(k == 1){
            for (int i = 0; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                System.out.print(tmpArr.toString() + ",");
                tmpArr.remove((Object)arr[i]);
            }
        }else if(k > 1){
            for (int i = 0; i < arr.length; i++) { //按顺序挑选一个元素
                tmpArr.add(arr[i]); //添加选到的元素
                arrangement(k - 1, removeArrayElements(arr, tmpArr.toArray(new Integer[1]))); //没有取过的元素，继续挑选
                tmpArr.remove((Object)arr[i]);
            }
        }else{
            return ;
        }
    }

    /**
     * 可重复排列
     * 类似自己和自己笛卡尔积，类似k层循环拼接的结果,元素个数[arr.len^3]
     * @param k 选取的元素个数（k层循环）
     * @param arr 数组
     */
    public static void repeatableArrangement(int k,int []arr){
        if(k==1){
            for(int i=0;i<arr.length;i++){
                tmpArr.add(arr[i]);
                System.out.print(tmpArr.toString() + ",");
                tmpArr.remove(tmpArr.size()-1); //移除尾部元素
            }
        }else if(k >1){
            for(int i=0;i<arr.length;i++){
                tmpArr.add(arr[i]);
                repeatableArrangement(k - 1, arr); //不去重
                tmpArr.remove(tmpArr.size()-1); //移除尾部元素,不能用remove(Object),因为它会移除头部出现的元素，我们这里需要移除的是尾部元素
            }
        }else{
            return;
        }
    }

    /**
     * 移除数组某些元素（不影响原数组）
     * @param arr 数组
     * @param elements 待移除的元素
     * @return 剩余元素组成的新数组
     */
    public static int[] removeArrayElements(int[] arr, Integer... elements){
        List<Integer> remainList = new ArrayList<>(arr.length);
        for(int i=0;i<arr.length;i++){
            boolean find = false;
            for(int j=0;j<elements.length;j++){
                if(arr[i] == elements[j]){
                    find = true;
                    break;
                }
            }
            if(!find){ //没有找到的元素保留下来
                remainList.add(arr[i]);
            }
        }
        int[] remainArray = new int[remainList.size()];
        for(int i=0;i<remainList.size();i++){
            remainArray[i] = remainList.get(i);
        }
        return remainArray;
    }

}
