package jinx.guangdian;

public class KeyUtils {


    public static final String DEVICE_URL = "http://carstop.jmwyw.com/action";
    public static final String STATUS_URL = "http://carstop.jmwyw.com/event";

//    public static final String DEVICE_URL = "http://event.park-man.com/action";
//    public static final String STATUS_URL = "http://event.park-man.com/event";


    public static String get(String s){
        String str = "";
        for(int i = 0;i<s.length();i++){
            String ss = String.valueOf(s.charAt(i));
            if("0".equals(ss)||"9".equals(ss)||"a".equals(ss)){
                str += "b";
            }else{
                str += s.charAt(i);
            }
        }
        return str;
    }

}
