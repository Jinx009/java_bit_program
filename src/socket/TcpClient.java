package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws Exception, IOException {
        Socket s = new Socket("192.168.59.3", 5000);

        OutputStream os = s.getOutputStream();

        os.write("Ji2nx21".getBytes());

        InputStream is = s.getInputStream();

        byte[] b = new byte[200];

        int length = is.read(b);

//			if(-1 !=(length = is.read(b, 0, length)))
//			{
//				String str = new String(b,0,length);
//				
//				System.out.println(str);
//			}

        System.out.println(new String(b, 0, length));

        os.close();
        is.close();
        s.close();
    }
}
