package jinx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Six {

    private static List<String> getLog(File fileName) {
        List<String> list3 = new ArrayList<String>();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while ((s = br.readLine()) != null) {
                list3.add(s);
            }
            br.close();
            return list3;
        } catch (IOException e) {

        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        List<String> list = getLog(new File("/Users/jinx/Downloads/tbl_sensor.txt"));
        File file=new File("/Users/jinx/Downloads/test");
        List<String> list2 = new ArrayList<String>();
        if(file.isDirectory()&&file.exists()){
            for(File temp:file.listFiles()){
                if(temp.isFile()&&temp.toString().contains(".txt")){
                    String name2 = temp.toString().split("/Users/jinx/Downloads/test/heart_log_0529_")[1];
                    list2.add(name2);
//                    System.out.println("array---"+name2);
                }
            }
        }
        int b = 1;
        for(String s:list){
//            System.out.println("ssss--"+s);
            int a = 1;
//            if(a ==1){
////                System.out.println("ssss--"+s);
//            }
            for(String s1:list2){
                String name = s1.split(".txt")[0];
//                System.out.println("name"+s1);
                if(name.equals(s))
                    a =2;
            }
            if(a ==1){
                System.out.println(b+"--"+s);
                b++;
            }
        }
    }

}
