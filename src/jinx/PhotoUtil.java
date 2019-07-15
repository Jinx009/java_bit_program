package jinx;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;


public class PhotoUtil {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    final static String photoX = "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";

    /**
     * @param srcFile 源图片、targetFile截好后图片全名、startAcross 开始截取位置横坐标、StartEndlong开始截图位置纵坐标、width截取的长，hight截取的高
     * @Description:截图
     */
    public static void cutImage(String srcFile, String targetFile, int startAcross, int StartEndlong, int width,
                                int hight) throws Exception {
        // 取得图片读入器
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = readers.next();
        // 取得图片读入流
        InputStream source = new FileInputStream(srcFile);
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        // 图片参数对象
        ImageReadParam param = reader.getDefaultReadParam();
        Rectangle rect = new Rectangle(startAcross, StartEndlong, width, hight);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0, param);
        ImageIO.write(bi, targetFile.split("\\.")[1], new File(targetFile));
    }

    /**
     * @param files 要拼接的文件列表
     * @param type  1 横向拼接， 2 纵向拼接
     * @Description:图片拼接 （注意：必须两张图片长宽一致哦）
     */

    public static void mergeImage(String[] files, int type, String targetFile) {
        int len = files.length;
        if (len < 1) {
            throw new RuntimeException("图片数量小于1");
        }
        File[] src = new File[len];
        BufferedImage[] images = new BufferedImage[len];
        int[][] ImageArrays = new int[len][];
        for (int i = 0; i < len; i++) {
            try {
                src[i] = new File(files[i]);
                images[i] = ImageIO.read(src[i]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            int width = images[i].getWidth();
            int height = images[i].getHeight();
            ImageArrays[i] = new int[width * height];
            images[i].getRGB(0, 0, width, height, ImageArrays[i], 0, width);
        }
        int newHeight = 0;
        int newWidth = 0;
        for (int i = 0; i < images.length; i++) {
            // 横向
            if (type == 1) {
                newHeight = newHeight > images[i].getHeight() ? newHeight : images[i].getHeight();
                newWidth += images[i].getWidth();
            } else if (type == 2) {// 纵向
                newWidth = newWidth > images[i].getWidth() ? newWidth : images[i].getWidth();
                newHeight += images[i].getHeight();
            }
        }
        if (type == 1 && newWidth < 1) {
            return;
        }
        if (type == 2 && newHeight < 1) {
            return;
        }

        // 生成新图片
        try {
            BufferedImage ImageNew = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            int height_i = 0;
            int width_i = 0;
            for (int i = 0; i < images.length; i++) {
                if (type == 1) {
                    ImageNew.setRGB(width_i, 0, images[i].getWidth(), newHeight, ImageArrays[i], 0,
                            images[i].getWidth());
                    width_i += images[i].getWidth();
                } else if (type == 2) {
                    ImageNew.setRGB(0, height_i, newWidth, images[i].getHeight(), ImageArrays[i], 0, newWidth);
                    height_i += images[i].getHeight();
                }
            }
            //输出想要的图片
            ImageIO.write(ImageNew, targetFile.split("\\.")[1], new File(targetFile));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据入参照片的个数自动组成一个缩略图，自动化布局
     * @param photoStr
     * @return
     */
    public static String mergeImageX(String[] photoStr) {
        String resPho = null;


        int size = photoStr.length;
        if (size > 1) {
            try { //行数
                int rowNum = (int) Math.floor(Math.sqrt(size));
                //列数
                int colNum = (int) Math.ceil((double) size / rowNum);
                String[][] ces = new String[rowNum][colNum];
                for (int r = 0; r < rowNum; r++) {
                    for (int c = 0; c < colNum; c++) {
                        if (r * colNum + c < size) {
                            ces[r][c] = photoStr[r * colNum + c];
                        } else {
                            ces[r][c] = photoX;
                        }
                    }
                }

                BufferedImage[][] images = new BufferedImage[rowNum][colNum];
                int width = base64StringToImage(ces[0][0]).getWidth();
                int height = base64StringToImage(ces[0][0]).getHeight();
                BufferedImage ImageNew = new BufferedImage(width * colNum, height * rowNum, BufferedImage.TYPE_INT_RGB);
                int[][][] ImageArrays = new int[rowNum][colNum][];
                for (int r = 0; r < rowNum; r++) {
                    for (int c = 0; c < colNum; c++) {
                        images[r][c] = base64StringToImage(ces[r][c]);
                        ImageArrays[r][c] = images[r][c].getRGB(0, 0, width, height, ImageArrays[r][c], 0, width);
                        ImageNew.setRGB(c * width, r * height, width, height, ImageArrays[r][c], 0, width);
                    }
                }
                //输出想要的图片
//            ImageIO.write(ImageNew, targetFile.split("\\.")[1], new File(targetFile));
                resPho = getImageBinary(ImageNew);
                return resPho;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    /**
     * 生成9人头像的合图
     *
     * @param photoStr
     * @return
     */
    public static String mergeImage9(String[] photoStr) {
        String resPho = null;
        int size = photoStr.length;
        if (size > 1) {
            try { //行数
                int rowNum = 3;
                //列数
                int colNum = 3;
                String[][] ces = new String[3][3];
                for (int r = 0; r < rowNum; r++) {
                    for (int c = 0; c < colNum; c++) {
                        if (r * colNum + c < size) {
                            ces[r][c] = photoStr[r * colNum + c];
                        } else {
                            ces[r][c] = photoX;
                        }
                    }
                }

                BufferedImage[][] images = new BufferedImage[rowNum][colNum];
                int width = base64StringToImage(ces[0][0]).getWidth();
                int height = base64StringToImage(ces[0][0]).getHeight();
                BufferedImage ImageNew = new BufferedImage(width * colNum, height * rowNum, BufferedImage.TYPE_INT_RGB);
                int[][][] ImageArrays = new int[rowNum][colNum][];
                for (int r = 0; r < rowNum; r++) {
                    for (int c = 0; c < colNum; c++) {
                        images[r][c] = base64StringToImage(ces[r][c]);
                        ImageArrays[r][c] = images[r][c].getRGB(0, 0, width, height, ImageArrays[r][c], 0, width);
                        ImageNew.setRGB(c * width, r * height, width, height, ImageArrays[r][c], 0, width);
                    }
                }
                //输出想要的图片
//            ImageIO.write(ImageNew, targetFile.split("\\.")[1], new File(targetFile));
                resPho = getImageBinary(ImageNew);
                return resPho;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    /**
     * @Description:小图片贴到大图片形成一张图(合成)
     */
    public static final void overlapImage(String bigPath, String smallPath, String outFile) {
        try {
            BufferedImage big = ImageIO.read(new File(bigPath));
            BufferedImage small = ImageIO.read(new File(smallPath));
            Graphics2D g = big.createGraphics();
            int x = (big.getWidth() - small.getWidth()) / 2;
            int y = (big.getHeight() - small.getHeight()) / 2;
            g.drawImage(small, x, y, small.getWidth(), small.getHeight(), null);
            g.dispose();
            ImageIO.write(big, outFile.split("\\.")[1], new File(outFile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 图片转base64操作
     *
     * @return
     */
    public static String getImageBinary(BufferedImage bufferedImage) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * base64转图片操作
     *
     * @param base64String
     */
    public static BufferedImage base64StringToImage(String base64String) {
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bufferedImage = ImageIO.read(bais);
            return bufferedImage;
        } catch (IOException e) {
            return null;
        }
    }
}
