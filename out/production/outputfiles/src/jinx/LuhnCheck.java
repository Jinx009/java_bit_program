package jinx;

/**
 * Created by jinx on 10/11/16.
 */
public class LuhnCheck {

    private static String getDigtsOnly(String s){
        StringBuffer digitsOnly = new StringBuffer();
        char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                digitsOnly.append(c);
            }
        }
        return digitsOnly.toString();
    }

    public static boolean isValid(String cardNumber){
        String digitsOnly = getDigtsOnly(cardNumber);
        int sum = 0;
        int digit = 0;
        int addend = 0;
        boolean timesTwo = false;

        for(int i = digitsOnly.length()-1;i>=0;i--){
            digit = Integer.parseInt(digitsOnly.substring(i,i+1));
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
        return modulus == 0;
    }

    public static void main(String[] args){
        System.out.println(isValid("620522001003644161"));
    }
}
