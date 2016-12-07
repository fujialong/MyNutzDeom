package cn.com.jero.mynutzdeom.resultUtil;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Administrator on 2016/11/23.
 */
public class DrawTranslucentPng {
    public static BufferedImage drawTranslucentStringPic(int width, int height, Integer fontHeight, String drawStr,String[] word,String rootpath,Color color)
    {
        try
        {
            BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D gd = buffImg.createGraphics();
            //设置透明  start
            buffImg = gd.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
            gd=buffImg.createGraphics();
            //设置透明  end
            gd.setFont(new Font("黑体", Font.BOLD, fontHeight)); //设置字体
            gd.setColor(color); //设置颜色
           // gd.drawRect(0, 0, width - 1, height - 1); //画边框
            gd.drawString(drawStr, 13,height-110); //输出文字（中文横向居中）

            BufferedImage img=ImageIO.read(new File(rootpath+"/Qcode6.png"));
            BufferedImage logo=ImageIO.read(new File(rootpath+"/wentitong6.png"));
            gd.drawImage(img,width-60, height-70,50,50,null);
            gd.drawImage(logo,10,10,50,50,null);
            gd.setFont(new Font("黑体",Font.BOLD,15));
            int length=3;//个数
            if(null!=word) {
                for (int i = 0; i < length; i++) {
                    gd.drawString(word[i], 14+i*4*16,295);
                }
            }
            gd.drawString("福田文体通", 15, 290 + 1 * 30);
            gd.drawString("方便的不像公众号", 15, 290 + 2 * 30);
            return buffImg;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args)
    {
        String[] word = {""};
        BufferedImage imgMap = drawTranslucentStringPic(232, 380, 30,"漂亮的不像实力派", word,"",Color.PINK);
        File imgFile=new File("D://www.cxyapi.com.png");
        try
        {
            ImageIO.write(imgMap, "PNG", imgFile);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("生成完成");
    }

    /**压缩字符串*/
    public static String GetCompress(String src)
    {
        if (src == null || src.isEmpty()) {
            return src;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        String des = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(src.getBytes());
            //由于压缩后的数据需要传输，所以用了BASE64编码
            //des = new BASE64Encoder().encode(out.toByteArray());
            des= out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(gzip!=null)
            {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return des;
    }
}
