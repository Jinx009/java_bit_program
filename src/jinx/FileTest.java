package jinx;

import java.io.File;

/**
 * 查找根目录下包含子目录下的所有文件
 */
public class FileTest {

    private static int i = 0;

    public static void main(String[] args) {
        String path = "/Users/jinx/Downloads/test/";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        func(file,i);
    }

    private static void func(File file,int i) {
        File[] fs = file.listFiles();
        for (File f : fs) {
            i++;
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f,i);
            if (f.isFile())        //若是文件，直接打印
                System.out.println(f);
        }
        System.out.println("_num:----"+i);
    }
}