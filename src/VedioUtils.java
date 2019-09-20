import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VedioUtils {

    public static void main(String[] args) throws ParseException {
        String fileName = "/Users/jinx/Downloads/2.mp4";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse("1998-01-01 00:00:00");
        String time = "";
        for( int i = -0;i<15;i++){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.SECOND,1);
            date = calendar.getTime();
            time = f.format(date);
            System.out.println(time);
            GifUtils.covPic(fileName,time,"/Users/jinx/Downloads/pic/"+time+".jpeg");
        }
//        String dianxin = "482B3529590000A0005900EE0002312E317835006F0C88FFECFEDBFE0F000012120A24082D030264C82773011C";
//        String jingan = "481d3e21ba3f0107322e31303000ca0d12120a28082d001264170007b5ac0018fd89002d01";
//        String chaozhou = "48623529b10001cefd94fb3f0007312e78313800520d10fe4dfbc00000000112120a24082d030250267b72001c";
//        System.out.println(dianxin.length()+"--"+jingan.length()+"--"+chaozhou.length());
    }

}
