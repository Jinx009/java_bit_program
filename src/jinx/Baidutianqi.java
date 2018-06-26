package jinx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jinx.guangdian.HttpUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Baidutianqi {

    public static void main(String[] args){
//        HttpUtils.sendPost("http://www.weather.com.cn/data/cityinfo/101220501.html","");
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = "http://www.weather.com.cn/data/cityinfo/101220501.html";
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            HttpURLConnection httpUrlCon = (HttpURLConnection)connection;
            httpUrlCon.connect();
            in = new BufferedReader(new InputStreamReader(
                    httpUrlCon.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject jsonObject = JSON.parseObject(result);
            System.out.println(jsonObject.get("weatherinfo"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
