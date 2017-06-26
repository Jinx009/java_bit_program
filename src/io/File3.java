package io;

import java.io.File;

/*
 * 遍历一个目录下的所有文件
 */
public class File3 {
    public static void main(String[] args) throws Exception {
        File file = new File("d:/workspace");
            /*
			 * 第一种方法
			 */
        String[] filenames = file.list();

        for (String name : filenames) {
            System.out.println(name);
        }
			/*
			 * 第二种方法
			 */
        System.out.println("*********************");

        File[] f = file.listFiles();

        for (File fi : f) {
            System.out.println(fi.getName() + "---------------------" + fi.getParent());
        }
    }
}
