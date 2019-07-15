package jinx;

import java.util.Random;

public class Cp {
    public static void main(String[] args){
            System.out.println(getCph());
    }

    private static String getCph(){
        String str2 = "ABCDEFGHJKLPQS";
        String str="ABCDEFGHJKLMNPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<4;i++){
            int number=random.nextInt(34);
            sb.append(str.charAt(number));
        }
        return "沪"+str2.charAt(random.nextInt(14))+sb.toString()+"警";
    }

}
