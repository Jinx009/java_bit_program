package jinx;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * JAVA中SHA1的加密与解密
 */
public class SHA1Test {

    /**
     * SHA1加密
     * @param decript
     * @return
     */
    public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args){
        String str = "待加密数据";
        String str2 = SHA1(str);
        System.out.println(str2);
    }

}
