package jinx;
public class Test {
    public static void main(String[] args) {
//        int[] array = new int[]{10,15,12,9,7};
//        int temp = 0;
//        int sum = 0;
//        for(int a:array){
//            if(a>=temp)
//                temp = a;
//            sum+= a;
//        }
//        System.out.print("数组求和结果为:"+sum);
//        System.out.print("数组最大元素为:"+temp);b
        String s = "sss";
        String s1 = "sss";
        String s2 = new String("sss");
        System.out.println(s==s1);
        System.out.println(s2==s1);
        System.out.println(s.equals(s1));
        Integer a = Integer.valueOf("AD",16);
        String b = Integer.toBinaryString(a);
        String c = "";
        for(String d : b.split("")){
            if(d.equals("1")){
                c+= "0";
            }else{
                c+= "1";
            }
        }
        Integer e = Integer.parseInt(c,2);
        System.out.println(e);
    }
}