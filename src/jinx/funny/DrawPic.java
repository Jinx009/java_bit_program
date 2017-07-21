package jinx.funny;

/**
 * Created by jinx on 7/21/17.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class DrawPic extends Applet {
    int width, height;
    Image image;        //缓冲区对象
    Graphics g1;

    public void init() {
        setBackground(Color.BLACK);
        this.setSize(350, 310);

        width = getSize().width;
        height = getSize().height;

        image = createImage(width, height);    //创建图像对象
        g1 = image.getGraphics();

    }

    public void paint(Graphics g) {
        g1.clearRect(0, 0, width, height);
        g1.setColor(Color.red);
        double r, x, y;
        //在缓冲区绘制图案
        for (int i = 0; i <= 90; i++) {
            for (int j = 0; j <= 90; j++) {
                //转换直角坐标
                r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + width / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + height / 4;
                g1.fillOval((int) x, (int) y, 2, 2);
            }
        }
        //显示缓存区的可变Image对象
        g.drawImage(image, 0, 0, this);
    }


    public static void main(String[] args) {

    }
}