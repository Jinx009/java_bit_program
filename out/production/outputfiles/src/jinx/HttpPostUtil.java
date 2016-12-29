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
        String menuStr = "{\"adType\":\"12\"}";

        String url = "http://172.17.192.93:8030/mapi/adList";

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        System.out.println(menuStr);
//        post.setEntity(new StringEntity(menuStr,"UTF-8"));
        post.setEntity(new StringEntity(menuStr, Charset.forName("UTF-8")));
        HttpResponse response = httpClient.execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(jsonStr);


    }

}
