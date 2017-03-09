package jinx;

import java.util.UUID;

/**
 * Created by jinx on 2/13/17.
 */
public class Test {
    public static void main(String[] args){
        String menuStr = "[{\"mac\":\"000478ad5d03\",\"channelId\":\"\",\"panId\":\"7\",\"heartbeatInterval\":\"60\"},{\"mac\":\"000478ad5d03\",\"channelId\":\"\",\"panId\":\"7\",\"heartbeatInterval\":\"60\"}]";
        System.out.print(MD5Test.MD5(menuStr));
    }

}
