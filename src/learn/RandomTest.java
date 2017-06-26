package learn;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 132; i++) {
            System.out.println(r.nextInt(899999) + 100000);
        }
    }
}
