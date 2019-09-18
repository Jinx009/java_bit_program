package jinx;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;

public class Cp {
    public static void main(String[] args){
//        String data = "00091906000000114806682A003A100000BCC600003C0C0000FFFE000D00000CA02414FCE400BC0053312E312E3000322E31303400";
//        String cmd =  data.substring(20, 22);
//        System.out.println(cmd.equals("68"));
//        String hex_num = "0168";
//        long dec_num = Long.parseLong(hex_num, 16);
//        System.out.println(dec_num);
//        Double valueTen = 0.2058;
//        String strHex = Double.toHexString(valueTen);
//        System.out.println(strHex);
        String data = "5A0A0729000104D1FF9D710201010304DD6DBC3F040432E4DDBF0C02F20C0D025F0111010117010E180100190100DB92";
        String cmd = data.substring(5, 6);
        String sn1 = data.substring(20, 22);
        String sn2 = data.substring(18, 20);
        String sn3 = data.substring(16, 18);
        String sn4 = data.substring(14, 16);
        long sn = Long.parseLong(sn1 + sn2 + sn3 + sn4, 16);
        if (cmd.equals("7")) {
            cmd = "心跳";
        } else if (cmd.equals("8")) {
            cmd = "报警";
        }
        String x1 = data.substring(38, 40);
        String x2 = data.substring(36, 38);
        String x3 = data.substring(34, 36);
        String x4 = data.substring(32, 34);
        String y1 = data.substring(50, 52);
        String y2 = data.substring(48, 50);
        String y3 = data.substring(46, 48);
        String y4 = data.substring(44, 46);
        String x = hexToFloat(x1 + x2 + x3 + x4);
        String y = hexToFloat(y1 + y2 + y3 + y4);
        String w1 = data.substring(58, 60);
        String w2 = data.substring(56, 58);
        Double w = Double.valueOf(Long.parseLong(w1 + w2, 16)) / 100;
        String b1 = data.substring(66, 68);
        String b2 = data.substring(64, 66);
        Double bat = Double.valueOf(Long.parseLong(b1 + b2, 16)) / 100;
        System.out.println(x+"---"+y+"----"+bat+"----"+sn+"----"+w);
//        System.out.println(getCph());
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

    private static String hexToFloat(String s) {
        BigInteger big = new BigInteger(s, 16);
        Float z = Float.intBitsToFloat(big.intValue());
        Double r = Double.valueOf(z);
        BigDecimal f = new BigDecimal(r);
        double g = f.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        String result = decimalFormat.format(g);
        return result;
    }

}
