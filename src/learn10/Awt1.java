package learn10;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Awt1 {
    private Frame frame;

    private Button btn1;

    private Button btn2;

    public void get() {
        frame = new Frame("Test");

        frame.setLayout(new FlowLayout());

        btn1 = new Button("btn1");

        btn2 = new Button("btn2");

        btn1.setBackground(Color.red);

        //frame.pack();

        frame.add(btn1);

        frame.add(btn2);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Awt1 t = new Awt1();

        t.get();
    }
}
