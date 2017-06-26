package learn10;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class Awt3 {
    private Frame frame;

    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    public void get() {
        frame = new Frame();
        frame.setLayout(new GridLayout(3, 2));

        btn1 = new Button("btn1");
        btn2 = new Button("btn2");
        btn3 = new Button("btn3");
        btn4 = new Button("btn4");
        btn5 = new Button("btn5");
        btn6 = new Button("btn6");

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);

        frame.pack();//压缩面积
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Awt3 w = new Awt3();
        w.get();
    }
}
