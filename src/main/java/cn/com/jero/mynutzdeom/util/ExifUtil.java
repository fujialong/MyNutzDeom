package cn.com.jero.mynutzdeom.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;

import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Administrator on 2016/12/2.
 *
 */
public class ExifUtil {

    public static int getOrientation(Image src,String orientation) {
        int tag = 0;
        if ("Top, left side (Horizontal / normal)".equalsIgnoreCase(orientation)) {
            tag = 1;
        } else if ("Top, right side (Mirror horizontal)".equalsIgnoreCase(orientation)) {
            tag = 2;
        } else if ("Bottom, right side (Rotate 180)".equalsIgnoreCase(orientation)) {
            tag = 3;
            Rotate(src,180);
        } else if ("Bottom, left side (Mirror vertical)".equalsIgnoreCase(orientation)) {
            tag = 4;
        } else if ("Left side, top (Mirror horizontal and rotate 270 CW)".equalsIgnoreCase(orientation)) {
            tag = 5;
            Rotate(src,270);
        } else if ("Right side, top (Rotate 90 CW)".equalsIgnoreCase(orientation)) {
            tag = 6;
            Rotate(src,90);
        } else if ("Right side, bottom (Mirror horizontal and rotate 90 CW)".equalsIgnoreCase(orientation)) {
            tag = 7;
        } else if ("Left side, bottom (Rotate 270 CW)".equalsIgnoreCase(orientation)) {
            tag = 8;
            Rotate(src,270);
        }
        return tag;
    }

    public static BufferedImage Rotate(Image src, int angel) {
        int src_width = src.getWidth(null);
        int src_height = src.getHeight(null);
        // calculate the new image size
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(
                src_width, src_height)), angel);

        BufferedImage res = null;
        res = new BufferedImage(rect_des.width, rect_des.height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = res.createGraphics();
        // transform
        g2.translate((rect_des.width - src_width) / 2,
                (rect_des.height - src_height) / 2);
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);

        g2.drawImage(src, null, null);
        return res;
    }

    public static Rectangle CalcRotatedSize(Rectangle src, int angel) {
        // if angel is greater than 90 degree, we need to do some conversion
        if (angel >= 90) {
            if(angel / 90 % 2 == 1){
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }

        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_height));
        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        return new Rectangle(new Dimension(des_width, des_height));
    }

    public static void main(String[] args) throws Exception {
      ExifUtil exifUtil=new ExifUtil();
        exifUtil.doIt("E:\\3.jpg");
    }

    public void doIt(String filePath)throws Exception{
        File jpegFile= new File(filePath);
        Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
        Directory directory = metadata.getFirstDirectoryOfType(ExifDirectoryBase.class);
        JpegDirectory jpegDirectory = (JpegDirectory)metadata.getFirstDirectoryOfType(JpegDirectory.class);
        if(directory!=null){
            //判断要转的角度
            int orientation=0;
            try {
                orientation = directory.getInt(ExifDirectoryBase.TAG_ORIENTATION);
            } catch (MetadataException me) {

            }
            System.out.println(orientation);
            BufferedImage src = ImageIO.read(jpegFile);
            BufferedImage des = RotateImage.Rotate(src, orientation);
            ImageIO.write(des,"jpg", new File(filePath));
        }

    }
}