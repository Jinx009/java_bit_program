package jinx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 将文件写入txt
 */
public class WriteWordsIntoTxt {

    /**
     * JAVA文本写入
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        String url = "/Users/jinx/Downloads/temp.txt";
        File file = new File(url);
        if(!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(url, true);
                fileWriter.write("添加一行代码\n");
                fileWriter.flush();
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileWriter fileWriter = new FileWriter(url, true);
            fileWriter.write("添加一行代码\n");
            fileWriter.flush();
        }
    }

}
