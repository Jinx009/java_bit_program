package jinx;

import java.text.DecimalFormat;

/**
 * Created by jinx on 12/29/16.
 */
public class DoubleFormat {

    public static void main(String[] args){
        Long l = 2l;
        Double d = Double.valueOf(l);
        DecimalFormat df   = new DecimalFormat("######0.00");
        System.out.println(df.format(d));
    }

}
