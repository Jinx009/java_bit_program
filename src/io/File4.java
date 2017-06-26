package io;

import java.io.File;

/*
 * 创建新目录
 */
public class File4 {
    public static void main(String[] args) {
        File file = new File("d:/abc");//上级目录必须存在才可以创建下级目录，否则报错

        file.mkdir();
    }
}
