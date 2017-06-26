package chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedTest {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:/file.txt");

        OutputStreamWriter osw = new OutputStreamWriter(fos);

        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("http://www.medivh.org");
        bw.write("\n");
        bw.write("http://www.medivh.cn");

        bw.close();

        FileInputStream fis = new FileInputStream("D:/file.txt");

        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(isr);

        System.out.println(br.readLine());

        System.out.println(br.readLine());

        System.out.println(br.readLine());

        br.close();
    }
}
