package jinx;


/**
 * Created by jinx on 9/28/16.
 * 校验银行卡 (部分信用卡校验有问题参照)
 */
public class BankCardCheck {

    public static String check(String bankCardNum){
        int sum = 0;
        int digit = 0;
        int addend = 0;
        if(bankCardNum==null||"".equals(bankCardNum))
            return "银行卡号不能为空!";

        int length = bankCardNum.length();
        boolean timesTwo = false;
        for (int i = length-1; i >=0; i--) {
            digit = Integer.valueOf(bankCardNum.substring(i,i+1));
            if(timesTwo){
                addend = digit*2;
                if(addend>9){
                    addend -= 9;
                }
            }else{
                addend = digit;
            }
            sum += addend;
            timesTwo = !timesTwo;
        }
        int modulus = sum%10;
        if (modulus == 0){
            return "success";
        }else{
            return "银行卡号不合法!";
        }
    }

    public static void main(String[] args) {
        System.out.println(check("62318500100056908"));
    }
}