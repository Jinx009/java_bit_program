package io;

import java.io.File;

/*
 * 使用递归删除一个路径下所有内容
 */
public class File8 {
    public static void deleteAll(File file) {
        if (file.isFile() || file.list().length == 0) {
            file.delete();
        } else {
            File[] files = file.listFiles();

            for (File f : files) {
                deleteAll(f);

                f.delete();
            }
        }
    }

    public static void printAll(String nbsp, File file) {
        if (file.isFile() || file.list().length == 0) {
            System.out.println(nbsp + file.getName());
        } else {
            nbsp += "**********";
            File[] files = file.listFiles();

            for (File f : files) {
                System.out.println(nbsp + file.getName());

                printAll(nbsp, f);
            }
        }
    }

    public static void main(String[] args) {
        printAll("", new File("d:/png/"));
    }
}
