package jinx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class HttpTest {
    private static int thread_num = 2000;
    private static int client_num = 2000;
    private static Map keywordMap = new HashMap();

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //2000个线程可以同时访问
        final Semaphore semp = new Semaphore(thread_num);
        //模拟2000个客户端访问
        for (int index = 0; index < client_num; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                            //获取许可
                            semp.acquire();
                            System.out.println("Thread:" + NO);
                            String host = "http://127.0.0.1:8080/toPay.html";
                            //需要访问的url
                            URL url = new URL(host);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setDoOutput(true);
                            connection.setDoInput(true);
                            PrintWriter out = new PrintWriter(connection.getOutputStream());
                            out.flush();
                            out.close();
                            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            String line = "";
                            String result = "";
                            while ((line = in.readLine()) != null) {
                                result += line;
                            }
                            System.out.println("第：" + NO + " 个result:"+result);
                            semp.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                exec.execute(run);
            }
            //退出线程池
            exec.shutdown();
        }

}