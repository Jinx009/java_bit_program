package jinx;


/**
 * Created by jinx on 9/28/16.
 * 校验银行卡
 */
public class BankCardCheck {

    public static String check(String bankCardNum){
        int sumOdd = 0,sumEven = 0;
        if(bankCardNum==null||"".equals(bankCardNum))
            return "银行卡号不能为空!";

        int length = bankCardNum.length();
        String lastNum = bankCardNum.substring(length-1,length);
        int temp = 0;
        bankCardNum = bankCardNum.substring(0,length-1);
        for (int i = length-1; i >=1; i--) {
            temp = Integer.valueOf(bankCardNum.substring(i-1,i));// 从末位一位开始提取，每一位上的数值
            if(length%2==1){
                if(i%2==0){
                    temp = 2*temp;
                    if(temp>10)
                        temp = temp - 9;
                    sumEven += temp;
                } else{
                    sumOdd += temp;
                }
            }else{
                if(i%2==1){
                    temp = 2*temp;
                    if(temp>10)
                        temp = temp - 9;
                    sumEven += temp;
                } else{
                    sumOdd += temp;
                }
            }
        }
        if ((sumOdd + sumEven+Integer.valueOf(lastNum)) % 10 == 0){
            return "success";
        }
        else{
            return "银行卡号不合法!";
        }
    }

    public static void main(String[] args) {
        System.out.println(check("6217580800000078105"));
    }
}