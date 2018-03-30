package jinx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileFromEndToStart {

    public static void main(String[] args){

    }

    private static String getLog(File fileName){
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
            BufferedReader br = new BufferedReader(reader);
            StringBuilder result = new StringBuilder();
            String s = null;
            List<String> list = new ArrayList<String>();
            while ((s = br.readLine()) != null) {
                list.add(System.lineSeparator() + s);
            }
            br.close();
            if(list!=null&&!list.isEmpty()){
                for(int i = list.size()-1;i>=0;i--){
                    result.append(list.get(i));
                }
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
