package io;

import java.io.File;

/*
 * 创建新文件
 */
public class File2 {
    public static void main(String[] args) throws Exception {
        File file = new File("d:/test.txt");

        file.createNewFile();
    }
}

