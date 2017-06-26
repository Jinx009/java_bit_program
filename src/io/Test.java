package io;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        byte[] b = new byte[10];

        for (int i = 0; i < 10; i++) {
            b[i] = (byte) i;
        }
        A a = new A(b);

        while (true) {
            int c = a.read();

            if (c < 0) {
                break;
            } else {
                System.out.println(c + "        ");
            }
        }
    }
}

class A extends InputStream {
    protected byte[] data;

    protected int s = 0;

    public A(byte[] data) {
        this.data = data;
    }

    public int read() throws IOException {
        return (s < data.length) ? (data[s++]) : -1;
    }

}
