package jinx;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {

    private final static int PORT = 7777;
    private static final String HOSTNAME = "106.14.94.245";


    public static void send(String data){
        try (DatagramSocket socket = new DatagramSocket(0)) {
            socket.setSoTimeout(10000);
            InetAddress host = InetAddress.getByName(HOSTNAME);
            byte[] buf = toBytes(data);
            DatagramPacket packet = new DatagramPacket(buf, buf.length,host, PORT);
            socket.send(packet);
            socket.close();
            System.out.println("send alreay");
        } catch (IOException e) {
            System.out.println("error:{}"+e);
        }
    }


    public static byte[] toBytes(String str) {//字符串转为16进制byte数组
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }

    public static void main(String[] args){
        send("000919032900000C69FFD20000B200FFEE00001A00FF9A000CF3089E00000000000000000000");
        String s = "{\"datastreams\":[{\"id\":\"012_1\",\"datapoints\":[{\"value\":{\"X\":0,\"Y\":0,\"Z\":0}}]}]}";
    }

}
