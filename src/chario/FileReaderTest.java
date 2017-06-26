package chario;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderTest {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("D:/file.txt");

        BufferedReader br = new BufferedReader(fr);

        String str;

        while (null != (str = br.readLine())) {
            System.out.println(str);
        }

        br.close();
    }
}
