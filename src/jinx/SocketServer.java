package jinx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static String start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket client = serverSocket.accept();
                new HandlerThread(client);
            }
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
        }
        return "success";
    }

    private static class HandlerThread implements Runnable {
        private Socket socket;
        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }
        public void run() {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientInputStr = input.readLine();
                System.out.println("Client msg is:" + clientInputStr);
//                PrintStream out = new PrintStream(socket.getOutputStream());
//                out.println("");
//                out.close();
                input.close();
            } catch (Exception e) {
                System.out.println("Server run exception: " + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("Server finally exception:" + e.getMessage());
                    }
                }
            }
        }
    }

    public static void main(String[] args){
//        start();
//        String a = "{\n" +
//                "  \"criteria\": {\n" +
//                "    \"serialNumbers\": [\n" +
//                "      \"863703031463248\"\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  \"deletionPolicy\": 0,\n" +
//                "  \"groupName\": \"DM.TEST.ZHANWAY\",\n" +
//                "  \"resources\": [\n" +
//                "    {\n" +
//                "      \"conditions\": {\n" +
//                "        \"pmin\": 0,\n" +
//                "        \"steps\": 0\n" +
//                "      },\n" +
//                "      \"resourcePath\": \"uplinkMsg/0/data\"\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"subscriptionType\": \"resources\"\n" +
//                "}";
        String a = "xxxxxx_111";
        System.out.println(a.split("_")[0]);
    }

}
