package jinx;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class StringTest {

    public static void main(String[] args){
        try{
            StringBuffer result = new StringBuffer();
            File file = new File("/Users/jinx/Downloads/snap.json");
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
            List<TestAAA> list = JSONArray.parseArray(result.toString(), TestAAA.class);
            double c = 0;
//            System.out.println("[");
            for(TestAAA test : list){
//                String[] a = test.getBalance().split("");
//                int b = Integer.valueOf(a[a.length-1]);
//                System.out.print(Double.valueOf(test.getBalance())+",");
//                b+= ;
//                if(b!=0){
//                    System.out.println(b);
//                }
//                if(test.getBalance().length()<=13){
                    c += Double.valueOf(test.getBalance());
//                }


            }
            System.out.println(c);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
class TestAAA{
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    private String addr;
    private String balance;

}