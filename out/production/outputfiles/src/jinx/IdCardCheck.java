package jinx;

import java.util.regex.Pattern;

/**
 * Created by jinx on 10/28/16.
 */
public class IdCardCheck {

    public static final String[] vcity = new String[100];

    static {
        for(int i= 0;i<100;i++){
            vcity[i] = null;
        }
        vcity[11] = "北京";
        vcity[12] = "天津";
        vcity[13] = "河北";
        vcity[14] = "山西";
        vcity[15] = "内蒙古";
        vcity[21] = "辽宁";
        vcity[22] = "吉林";
        vcity[23] = "黑龙江";
        vcity[31] = "上海";
        vcity[32] = "江苏";
        vcity[33] = "浙江";
        vcity[34] = "安徽";
        vcity[35] = "福建";
        vcity[36] = "江西";
        vcity[37] = "山东";
        vcity[41] = "河南";
        vcity[42] = "湖北";
        vcity[43] = "湖南";
        vcity[44] = "广东";
        vcity[45] = "广西";
        vcity[46] = "海南";
        vcity[50] = "重庆";
        vcity[51] = "四川";
        vcity[52] = "贵州";
        vcity[53] = "云南";
        vcity[54] = "西藏";
        vcity[61] = "陕西";
        vcity[62] = "甘肃";
        vcity[63] = "青海";
        vcity[64] = "宁夏";
        vcity[65] = "新疆";
        vcity[71] = "台湾";
        vcity[81] = "香港";
        vcity[82] = "澳门";
        vcity[91] = "国外";
    }




    /**
     * 校验身份证号码
     * @param idCardNum
     * @return
     */
    public static String validateIdCard(String idCardNum){
        idCardNum = idCardNum.toUpperCase();
        if(idCardNum==null||"".equals(idCardNum))
            return "身份证号不能为空!";
        else if(!isCardNum(idCardNum))
            return "请仔细核对您的身份证号码";
        else if(!checkProvince(idCardNum))
            return "请仔细核对您的身份证号码";
        else if(!checkParity(idCardNum))
            return "请仔细核对您的身份证号码";

        return "success";
    }

    /**
     * 校验身份证长度以及字符串
     * @param idCardNum
     * @return
     */
    private static boolean isCardNum(String idCardNum){
        String reg = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";
        return Pattern.matches(reg,idCardNum);
    }

    /**
     * 校验身份证省份是否正确
     * @param idCardNum
     * @return
     */
    private static boolean checkProvince(String idCardNum){
        String province = idCardNum.substring(0, 2);
        if(vcity[Integer.valueOf(province)] == null)
            return false;
        return true;
    }

    /**
     * 校验身份证
     * @param idCardNum
     * @return
     */
    private static boolean checkParity(String idCardNum){
        //15位转18位
        int len = idCardNum.length();
        if(len == 18) {
            int[] arrInt = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            String[] arrCh = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
            int cardTemp = 0;
            for(int i = 0; i < 17; i ++) {
                cardTemp += Integer.valueOf(idCardNum.substring(i, i+1)) * arrInt[i];
            }
            String valnum = arrCh[cardTemp % 11];
            if (valnum.equals(idCardNum.substring(17)))
                return true;
            return false;
        }else
            return true;
    }



    public static void main(String[] args){

        System.out.println(validateIdCard("41128219920708551x"));
    }

}
