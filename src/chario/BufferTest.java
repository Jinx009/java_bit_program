package chario;

import java.io.FileWriter;
import java.io.IOException;

public class BufferTest {
    public static void main(String[] args) throws IOException {
        String str = "Hello Medivh ,Are you ok?";

        char[] c = new char[str.length()];

        str.getChars(0, str.length(), c, 0);

        FileWriter fw = new FileWriter("D:/file.txt");

        for (int i = 0; i < c.length; i++) {
            fw.write(c[i] + "\n");
        }

        fw.close();
    }
}
