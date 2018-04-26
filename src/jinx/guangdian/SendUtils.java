package jinx.guangdian;

import java.util.Date;

public class SendUtils {

    private static final String DEVICE_URL = "http://www.huabanma.cn/detector/shanghaizhanwei/checkDevid.php";
    private static final String STATUS_URL = "http://www.huabanma.cn/detector/shanghaizhanwei/checkDevidStatus.php";
//
//    public static String sendStatus(String mac,int status,String eventTime,String routerMac){
//        String res = "{\"status\":0}";
//        try {
//            Date date = new Date();
//            String url = KeyUtils.STATUS_URL+"?";
//            String params = "id3="+routerMac+"&devid="+mac+"&tick="+date.getTime()+"&event="+status+"&eventtime="+eventTime;
//            url += params+"&sign="+KeyUtils.get(MD5Utils.MD5(params).toLowerCase());
//            System.out.println("[HttpUtils.sendDeviceStatus:{}]"+url);
//            res = HttpUtils.sendPost(url,"");
//        }catch (Exception e){
//            System.out.println("[HttpUtils.sendStatuserror:{}]"+e);
//        }finally {
//            return res;
//        }
//    }
    public static String sendStatus(String mac,int status,String eventTime,String routerMac){
        String res = "{\"status\":0}";
        try {
            Date date = new Date();
            String params = "id3="+routerMac+"&devid="+mac+"&tick="+date.getTime()+"&event="+status+"&eventtime="+eventTime;
            params += "&sign="+MD5Utils.MD5(params+"HUABANMA").toLowerCase();
            System.out.println("[HttpUtils.sendDeviceStatus:{}]"+params);
            res = HttpUtils.sendPost(STATUS_URL,params);
        }catch (Exception e){
            System.out.println("[HttpUtils.sendStatuserror:{}]"+e);
        }finally {
            return res;
        }
    }


    public static void main(String[] args){
        sendStatus("020000fffe000310",1,"1524728519000","0004a8f3e8bf");
    }

}
