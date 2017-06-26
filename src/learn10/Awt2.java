package learn10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class Awt2 {
    private Frame fra;
    private Button btn, btn2, btn3, btn4;

    public void get() {
        fra = new Frame("New");

        btn = new Button("btn1");
        btn2 = new Button("btn2");
        btn3 = new Button("btn3");
        btn4 = new Button("btn4");

        fra.add(btn, BorderLayout.NORTH);
        fra.add(btn2, BorderLayout.SOUTH);
        fra.add(btn3, BorderLayout.EAST);
        fra.add(btn4, BorderLayout.WEST);

        fra.setSize(300, 400);

        fra.setVisible(true);
    }

    public static void main(String[] args) {
        Awt2 w = new Awt2();

        w.get();
    }
}
