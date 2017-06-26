package io;

import java.io.File;
import java.io.FilenameFilter;

/*
 * 查找一个目录下后缀固定的文件
 */
public class File7 {
    public static void main(String[] args) {
        File file = new File("D:/Test/pdf/");

        String[] names = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (name.endsWith(".pdf")) {
                    return true;
                }

                return false;
            }

            ;
        });

        for (String name : names) {
            System.out.println(name);
        }
    }
}
