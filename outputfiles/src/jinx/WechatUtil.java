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

    public static final String appId = "wxd";
    public static final String appSecret = "7c62d78bfa8bc860845c5f9e3f68e775";
    public static final String accessToken = "XL91B2refRPkEd8TC_w-VoGtEewj6CaZqgkRnim_l7r8OSDHbzSuyXyw72eNEaQcRtDaC9LUMGvkBuJ1xAv35Qg0aifJkmXSB6QdAH1IQSDkEUhaLO51BkrlqT62SNhmJAQgACAFWM";


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
                    "{\"button\":["+
                        "{\"name\":\"物业360\",\"sub_button\":["+
                            "{\"type\":\"view\",\"name\":\"浦东空港\",\"url\":\"http:\\/\\/www.720qj.com\\/s1\\/a2.aspx?id=3842\"}"+
                        "]},"+
                        "{\"name\":\"物业项目\",\"sub_button\":["+
                            "{\"type\":\"click\",\"name\":\"物业出租\",\"key\":\"V_RENT\"},"+
                            "{\"type\":\"click\",\"name\":\"开发项目\",\"key\":\"V_DEV\"},"+
                            "{\"type\":\"click\",\"name\":\"我们的客户\",\"key\":\"V_CUSTOMER\"}"+
                        "]},"+
                        "{\"name\":\"关于嘉民\",\"sub_button\":["+
                            "{\"type\":\"view\",\"name\":\"嘉民概况\",\"url\":\"http:\\/\\/zvlnuf.epub360.com\\/v2\\/manage\\/book\\/hpdbr5\\/\"},"+
                            "{\"type\":\"click\",\"name\":\"新闻中心\",\"key\":\"V_NEWS\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"嘉民关怀\",\"key\":\"V_CARE\"},"+
                            "{\"type\":\"view\",\"name\":\"创新思维\",\"url\":\"http:\\/\\/cn.goodman.com\\/about-us\\/outdoor\"},"+
                            "{\"type\":\"view\",\"name\":\"加入我们\",\"url\":\"http:\\/\\/cn.goodman.com\\/about-us\\/working-at-goodman\"}" +
                        "]}"+
                     "]}";

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
        //getAccessToken();
        System.out.println(getMenuJson());
        //createMenu();
    }




}
