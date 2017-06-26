package io2;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStramTest {
    public static void main(String[] args) throws Exception {
        OutputStream io = new FileOutputStream("D:/out.txt");

        String str = "诅咒之下，欢乐何在！";

        io.write(str.getBytes());

        io.close();
    }
}
