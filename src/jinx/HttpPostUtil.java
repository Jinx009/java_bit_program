package jinx;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by jinx on 12/13/16.
 */
public class HttpPostUtil {

    public static void main(String[] args) throws IOException {
        String menuStr = "{" +
                "\"baseId\":\"000478ad5d03\"," +
                "\"fatherType\":1," +
                "\"sonType\":1," +
                "\"father\":{ \"mac\":\"10086\"," +
                "\"channelId\":\"\"," +
                "\"lastSeenTime\":\"2017-02-28 08:55:47\"," +
                "\"panId\":\"7\"," +
                "\"heartbeatInterval\":\"120\"" +
                "}," +
                "\"sign\":\"000478ad5d03\"," +
                "\"signType\":0," +
                "\"son\":" +
                "[" +
                "{\"mac\":\"000478ad5d03\"," +
                "\"channelId\":\"\"," +
                "\"panId\":\"7\"," +
                "\"heartbeatInterval\":\"60\"" +
                " }," +
                "{ \"mac\":\"000478ad5d03\"," +
                "\"channelId\":\"\"," +
                "\"panId\":\"7\"," +
                "\"heartbeatInterval\":\"60\"" +
                "}" +
                "]" +
                "}";

        String url = "http://127.0.0.1:9001/iot/common/iot/uploadData";

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-type","application/json; charset=utf-8");
        post.setHeader("Accept", "application/json");
        post.setEntity(new StringEntity(menuStr, Charset.forName("UTF-8")));
        HttpResponse response = httpClient.execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(jsonStr);


    }

}
