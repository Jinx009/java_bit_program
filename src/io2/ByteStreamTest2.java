package io2;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ByteStreamTest2 {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream by = new ByteArrayOutputStream();

        String str = "可以用 force参数   关闭当前运行数据库后正常启动。";

        by.write(str.getBytes());

        byte[] b = by.toByteArray();

        for (int i = 0; i < b.length; i++) {
            System.out.println((char) b[i]);
        }

        OutputStream os = new FileOutputStream("d:/test1.txt");

        by.writeTo(os);

        os.close();

        by.close();

    }
}
