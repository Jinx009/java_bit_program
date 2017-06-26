package chario;

import java.util.Properties;

public class ProTest {
    public static void main(String[] args) {
        Properties p = System.getProperties();

        p.list(System.out);
    }
}
