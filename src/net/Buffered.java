package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Buffered {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.9mirrors.com");

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        String line = null;

        while (null != (line = br.readLine())) {
            System.out.println(line);
        }
    }
}
