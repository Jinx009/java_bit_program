package jinx;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by jinx on 11/4/16.
 * JAVA获取文本内容
 */
public class IOReadTxt {

    public static void main(String[] args) throws Exception{
        String txtUrl = System.getProperty("user.dir")+"/outputfiles/test.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(txtUrl)));
        StringBuffer buffer = new StringBuffer();
        String data = "";
        while((data = br.readLine())!=null) {
            buffer.append(data);
        }
        System.out.print(buffer.toString());
    }

}
