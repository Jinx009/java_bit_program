package learn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sunlang {
    static Pattern pattern = Pattern.compile("[0-9]*");


    public static String sunCao(String sun) {
        Matcher isNum = pattern.matcher(sun);
        if (isNum.matches()) {
            return "JBshi";
        } else {
            return "Jbbushi!";
        }
    }

    public static void main(String[] args) {
        Sunlang.sunCao("dshkfdskjhsi1");
    }
}
