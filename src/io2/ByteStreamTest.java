package io2;

import java.io.ByteArrayInputStream;

import javax.print.attribute.standard.Chromaticity;

public class ByteStreamTest {
    public static void main(String[] args) {
        String str = "medivh";

        byte[] b = str.getBytes();

        ByteArrayInputStream io = new ByteArrayInputStream(b);

        for (int i = 0; i < 2; i++) {
            int c = 0;

            while (-1 != (c = io.read())) {
                if (0 == c) {
                    System.out.println(c);

                    System.out.println((char) c);
                } else {
                    System.out.println(c);

                    System.out.println(Character.toUpperCase((char) c));
                }
            }
        }

        io.reset();

    }
}
