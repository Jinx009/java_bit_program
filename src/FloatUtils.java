import java.math.BigInteger;

public class FloatUtils {

    public static void main(String[] args){
        int a  = Float.floatToIntBits(1f);
        String x = Integer.toHexString(a).toUpperCase();
        System.out.println(x);
        BigInteger big = new BigInteger(x, 16);
        Float z = Float.intBitsToFloat(big.intValue());
        System.out.println(z);
    }

}
