package jinx;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 微信公众号的一些操作
 */
public class WechatUtil {

    public static final String appId = "wx7c1fd7f9fd7f887";
    public static final String appSecret = "c615bb23228ec3c3cba61a6fcf129ee2";
    public static final String accessToken = "9_QIWhYaFIYWh4qHakS1vW5FqN9h0JtnCPTv6lhGx6cPi-uuvhx3khOtSZFONw5yzO4oZNHCXXOlh_JHm_5vrw9lkuxaBXXkfLhzE8Edu2lC8vQVrHERTWHCc4KdBS6mppvbn0Lj_0AXjuoSfSGKTbADAWAJ";


    /**
     *获取access_token
     * @throws IOException
     */
    public static void getAccessToken() throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
        url = url+ "&appid="+appId+"&secret="+appSecret;

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse;
        httpResponse = client.execute(httpGet);

        String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println("access_token:"+strResult);
    }

    /**
     * 获取当前菜单json
     * @return
     * @throws IOException
     */
    public static String getMenuJson() throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token="+accessToken;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse;
        httpResponse = client.execute(httpGet);
        String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        return strResult;
    }

    /**
     * 新建菜单
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static void createMenu() throws IOException {
                String menuStr =
                "{\n" +
                        "    \"button\": [" +
                        "        {" +
                        "            \"type\": \"view\"," +
                        "            \"name\": \"微信停车\"," +
                        "            \"url\": \"http://wx.zhanway.com/gtw/weixin/h5/payment\"" +
                        "        }," +
                        "        {" +
                        "            \"type\": \"view\"," +
                        "            \"name\": \"泊车\"," +
                        "            \"url\": \"http://wx.zhanway.com/gtw/weixin/h5/location\"" +
                        "        }," +
                        "        {" +
                        "            \"type\": \"view\"," +
                        "            \"name\": \"车位预览\"," +
                        "            \"url\": \"http://app.zhanway.com/themes/park/index.html" +
                        "        }" +
                        "    ]" +
                        "}";

        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+ accessToken;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        System.out.println(menuStr);
        post.setEntity(new StringEntity(menuStr,"UTF-8"));
        HttpResponse response = httpClient.execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(jsonStr);
    }

    public static void main(String[] args) throws  IOException{
//           getAccessToken();
        //   System.out.println(getMenuJson());
         createMenu();
    }




}
