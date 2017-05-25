package jinx;

/**
 * Unicode与String互转
 */
public class UnicodeTest {

    /**
     * String转成Unicode编码
     * @param string
     * @return
     */
    public static String stringToUnicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * Unicode编码转String
     * @param unicode
     * @return
     */
    public static String unicodeToString(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }

    public static void main(String[] args){
        String str = "测试文本";
        String unicodeStr = stringToUnicode(str);
        System.out.println(unicodeStr);
        String string = unicodeToString(unicodeStr);
        System.out.println(string);
    }

}
