package io2;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamTest {
    public static void main(String[] args) throws Exception {
        InputStream io = new FileInputStream("d:/test.txt");

        byte[] head = new byte[200];//设置读取范围

        String code = "";

        code = "gb2312";

        if (head[0] == -1 && head[1] == -2) {
            code = "UTF-16";
        }
        if (head[0] == -2 && head[1] == -1) {
            code = "Unicode";
        }
        if (head[0] == -17 && head[1] == -69 && head[2] == -65) {
            code = "UTF-8";
        }

        String str = "";

        int length = 0;

        while (-1 != (length = io.read(head, 0, 200)))//只读取不为空的数据
        {
            System.out.println(length);

            str = new String(head, 0, length, code);//将读取信息用特定编码存入字符串中

            System.out.println(str);
        }

        io.close();//关闭流
    }
}
