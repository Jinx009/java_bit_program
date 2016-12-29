package jinx;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jinx on 11/21/16.
 */
public class StringToDate {

    public static void main(String[] args) throws Exception{
        String dateStr = "2016-11-16 20:21:21";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateStr);
        System.out.println(date.toLocaleString());
        System.out.println(String.valueOf(1));
        System.out.println(String.valueOf(null));

        String res1 = "522B70714E75504B52326A4A37694C7A656C4757382B74346B67676B4261627230564A2B6F416B6F6D726C63726F4E6745784158366336697576704F4A56527045534E305852796D2F5A354D46784172535855316C72556677782F62666F75487A62566D326A5744724A5243665637434D6361756C776E77737257534C447039324775536A5A436674666D6267417A6D484332572F43456C314B35686D62485168477044516F5645364B6B41475A627061364368417934354A34797A48314464367A59414C3748346A7651392F3131467253564B70773D3D";
        String res2 = "";
    }

}
