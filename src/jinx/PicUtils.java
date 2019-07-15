package jinx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class PicUtils {

    public static void createPicTwo2(String[] picPath)
    {
        try
        {
            int width = 2688;//图片宽度
            int height = 1520;//图片高度

            File file_1 = new File(picPath[0]);
            BufferedImage image_1 = ImageIO.read(file_1);
            int[] array_1 = new int[width*height];
            array_1 = image_1.getRGB(0,0,width,height,array_1,0,width);

            File file_2 = new File(picPath[1]);
            BufferedImage image_2 = ImageIO.read(file_2);
            int[] array_2 = new int[width*height];
            array_2 = image_2.getRGB(0,0,width,height,array_2,0,width);

            File file_3 = new File(picPath[2]);
            BufferedImage image_3 = ImageIO.read(file_3);
            int[] array_3 = new int[width*height];
            array_3 = image_3.getRGB(0,0,width,height,array_3,0,width);

            File file_4 = new File(picPath[3]);
            BufferedImage image_4 = ImageIO.read(file_4);
            int[] array_4 = new int[width*height];
            array_4 = image_4.getRGB(0,0,width,height,array_4,0,width);

            //生成新图片
            BufferedImage ImageNew = new BufferedImage(2*width,2*height,BufferedImage.TYPE_INT_RGB);
            ImageNew.setRGB(0,0,width,height,array_1,0,width);
            ImageNew.setRGB(width,0,width,height,array_4,0,width);
            ImageNew.setRGB(0,height,width,height,array_2,0,width);
            ImageNew.setRGB(width,height,width,height,array_3,0,width);
            File outFile = new File("/Users/jinx/Downloads/5.jpeg");
            ImageIO.write(ImageNew, "jpeg", outFile);//写图片


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PicUtils he = new PicUtils();
        String[] s = new String[]{"/Users/jinx/Downloads/spic1.jpeg",
                "/Users/jinx/Downloads/spic2.jpeg",
                "/Users/jinx/Downloads/spic4.jpeg",
                "/Users/jinx/Downloads/spic5.jpeg",};
        he.createPicTwo2(s);
    }
}
