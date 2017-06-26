package learn10;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class AwtTest extends Frame {
    private static final long serialVersionUID = 1L;

    public AwtTest(String title) {
        super(title);
    }

    public static void main(String[] args) {
        AwtTest test = new AwtTest("My First");

        Panel panel = new Panel();

        panel.setSize(200, 400);

        panel.setBackground(Color.black);

        test.setLayout(null);

        test.setSize(900, 600);

        //test.setBackground(new Color(232,248,123));

        test.setBackground(Color.cyan);

        test.setVisible(true);

        test.add(panel);
    }
}
