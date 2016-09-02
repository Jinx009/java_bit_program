package jinx;

import java.util.Base64;

/**
 * JDK8中Base64测试
 */
public class JDK8Base64Test {

    public static void main(String[] args){

        String str = "待加密";
        String str2 = Base64.getEncoder().encodeToString(str.getBytes());
        byte[] byteArray = str2.getBytes();
        String str3 = new String(Base64.getDecoder().decode(byteArray));

        System.out.println(str2);
        System.out.println(str3);
    }

}
