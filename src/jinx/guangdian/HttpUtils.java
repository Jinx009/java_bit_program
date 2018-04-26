package jinx.guangdian;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class HttpUtils {

    /**
     * post json
     * @param url
     * @param json
     * @return
     */
    public static String postJson(String url, String json) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-type", "application/json; charset=utf-8");
            post.addHeader("Accept", "application/json");
            post.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
            HttpResponse response = httpClient.execute(post);
            String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            return jsonStr;
        } catch (Exception e) {
        }
        return "";
    }



    public static String postTextJson(String url, String json) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-type", "text/json; charset=utf-8");
            post.addHeader("Accept", "text/json");
            post.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
            HttpResponse response = httpClient.execute(post);
            String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            return jsonStr;
        } catch (Exception e) {
        }
        return "";
    }









    /**
     * 标准post
     * @param url
     * @param param
     * @return
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

}
