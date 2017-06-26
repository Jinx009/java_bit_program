package learn10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import junit.framework.TestCase;

public class Button1 extends TestCase {
    public void test1() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Test");

        Button b = new Button("btn");

        b.addActionListener(new Action());

        frame.add(b, BorderLayout.NORTH);

        frame.pack();

        frame.setVisible(true);
    }
}

class Action implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ok");
    }

}