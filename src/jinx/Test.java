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
//        String s = "sss";
//        String s1 = "sss";
//        String s2 = new String("sss");
//        System.out.println(s==s1);
//        System.out.println(s2==s1);
//        System.out.println(s.equals(s1));
        Integer a = Integer.valueOf("085F",16);
        String b = Integer.toBinaryString(a);
        System.out.println("b+"+b);
        String[] arr = b.split("");
        String status = arr[0];
        System.out.println("status+"+status);
        String c = "";
        Integer e = Integer.parseInt(b,2);
        if("1".equals(status)&&arr.length%2==0){
            for(String d : arr){
                if(d.equals("1")){
                    c+= "0";
                }else{
                    c+= "1";
                }
            }
            e = (Integer.parseInt(c,2)+1)*-1;
        }
        System.out.println(e);
        System.out.println(String.valueOf(Integer.parseInt("085F",16)));
//        System.out.printf("x = %ud, y = %d", 0xAD,0xAD);
    }
}