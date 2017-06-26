package io;

import java.io.File;
import java.io.IOException;

/*
 * 删除文件，永久删除
 */
public class File5 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/1.jpg");

        file.delete();
    }
}
