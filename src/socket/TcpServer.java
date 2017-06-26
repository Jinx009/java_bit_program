package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ServerSocket ss = new ServerSocket(5000);

        Socket s = ss.accept();

        InputStream is = s.getInputStream();

        byte[] b = new byte[200];

        int length = is.read(b);

        System.out.println(new String(b, 0, length));
//		
//		if(-1 != (length = is.read(b)))
//		{
//			System.out.println(new String(b,0,length));
//		}

        OutputStream os = s.getOutputStream();

        os.write("Welcom".getBytes());

        is.close();
        os.close();
        s.close();

    }
}
