package jinx;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JAVA时间比较先后顺序程序
 */
public class TimeCompareTest {

    public static void main(String[] args) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String endTime = "2016-10-01";
        Date nowDate = new Date();
        Date endDate = format.parse(endTime);
        if(endDate.before(nowDate)){
            System.out.println("时间已过期");
        }else{
            System.out.println("时间还没到");
        }

        System.out.println(nowDate.getHours());
    }

}
