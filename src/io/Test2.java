package io;

import java.io.IOException;
import java.io.InputStream;


public class Test2 extends InputStream {
    protected byte[] data;

    protected int num = 0;

    protected int sun = 0;

    public int read() throws IOException {
        return (num < data.length) ? data[num++] : -1;
    }

    public int available() throws IOException {
        return data.length - num;
    }

    public void close() throws IOException {
        num = data.length;
    }

    public synchronized void mark(int readlimit) {
        this.sun = readlimit;
    }

    public synchronized void reset() throws IOException {
        if (sun < 0 || sun > data.length) {
            throw new IOException("这不科学！");
        }
        num = sun;
    }

    public boolean markSupported() {
        return true;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        if (this.num > data.length || len < 0) {
            return -1;
        }
        if (len == 0) {
            return 0;
        }
        if (this.num + len > data.length) {
            return -1;
        }
        System.arraycopy(data, num, b, off, len);

        num += len;

        return len;
    }
}
