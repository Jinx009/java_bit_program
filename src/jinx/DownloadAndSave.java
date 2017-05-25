package jinx;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by jinx on 10/21/16.
 */
public class DownloadAndSave {

    public static String downToLocal(String mediaId) throws Exception{
        String urlString = "http://files.jb51.net/file_images/article/201312/20131220172328931.jpg";
        String result = "";
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        int code = httpURLConnection.getResponseCode();

        String contentType = httpURLConnection.getContentType();
        InputStream inputStream = httpURLConnection.getInputStream();
        if(code == 200 && contentType.equals("text/plain")){
            //如果是text的文本内容，说明不是正常的媒体流
            String content = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                content+=line;
            }

        }else if(code == 200 && contentType.split("/").length == 2 ){//contentType.equals("image/jpeg")){
            //如果可能是媒体文件
            boolean isMediaFile = false;
            String responseMediaType = contentType.split("/")[0];
            String responseMediaFormate = contentType.split("/")[1];

            switch(responseMediaType){
                case "audio":
                    isMediaFile = true;
                    break;
                case "image":
                    isMediaFile = true;
                    break;
            }
            if(isMediaFile){
                String filename = new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() )+ UUID.randomUUID();
                FileOutputStream fos = new FileOutputStream("/Users/jinx/Downloads/"+filename+"."+responseMediaFormate);
                byte[] b = new byte[1024];
                while((inputStream.read(b)) != -1){
                    fos.write(b);
                }
                inputStream.close();
                fos.close();
            }
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(downToLocal(""));
    }

}
