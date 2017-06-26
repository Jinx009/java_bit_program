package io;

import java.io.File;

/*
 * 判断一个路径代表的是否为文件
 */
public class File1 {
    public static void main(String[] args) throws Exception {
        File file = new File("d:/0.jpg");

        System.out.println(file.isFile());

    }
}
