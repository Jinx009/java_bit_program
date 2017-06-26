package net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Net1 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.9mirrors.com/9mirrors/9m/pdf/bxh/5310dfb746131b9d0146138259370002");

        String host = url.getHost();

        String file = url.getFile();

        int port = url.getPort();

        System.out.println(host + "*" + file + "*" + port);

        URLConnection u = url.openConnection();

        InputStream is = u.getInputStream();

        InputStream is1 = url.openStream();

        OutputStream os = new FileOutputStream("d:/html.pdf");

        int length = 0;

        byte[] b = new byte[2048];
        while (-1 != (length = is.read(b, 0, b.length))) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}
