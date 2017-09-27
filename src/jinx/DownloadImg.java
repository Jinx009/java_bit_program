package jinx;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class DownloadImg {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String url = "https://www.instagram.com/graphql/query/?query_id=17888483320059182&variables=%7B%22id%22%3A%223145747347%22%2C%22first%22%3A12%2C%22after%22%3A%22AQALsHIamstwwLioQHB2teQG4mh-vYMJP8NO7NT0CYUOb_M3Pis_GkzynUkfLvcHr_Rx4dGh31z4L6S6MA_dc99s7l_YZMaIOGsx1frp157ceg%22%7D";
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse;
        httpResponse = client.execute(httpGet);
        String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println(JSON.toJSONString(strResult));
//        download("http://ui.51bi.com/opt/siteimg/images/fanbei0923/Mid_07.jpg", "51bi.gif", "c:\\image\\");
    }

    public static void download(String urlString, String filename, String savePath) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5 * 1000);
        // 输入流
        InputStream is = con.getInputStream();

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf = new File(savePath);
        if (!sf.exists()) {
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

}