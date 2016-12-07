package cn.com.jero.mynutzdeom;

import cn.com.jero.mynutzdeom.resultUtil.QRCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/29.
 */
public class test {


    public static void main(String[] args) {
        String sss="style=1&word[]=1&word[]=2&word[]=&word[]=&word[]=&word[]=&word[]=&word[]=&word[]=&identity=1&gender=3&color=1&image=data%3Aimage";
         String s=sss.substring(0,sss.lastIndexOf("&image"));
        System.out.println("s:"+s);
        String type=s.substring(6,7);
      //  System.out.println(type);
        //文字
        System.out.println( s.substring(s.indexOf("&word[]"),s.indexOf("&identity")));
        String[] ss=s.substring(s.indexOf("&word[]"),s.indexOf("&identity")).split("&word\\[]=");
        System.out.println(ss.length);
        for (int i=1;i<ss.length;i++){
            System.out.println("***"+ss[i]);
        }

        //
        System.out.println(s.substring(s.indexOf("&color=")).split("color=")[1]);
        System.out.println(s.substring(s.indexOf("&gender=")).substring(8,9));
        //System.out.println(s.substring(s.indexOf("&color="),1).split("color=")[1]);
        try {
            BufferedImage image=ImageIO.read(new File("D:\\3.png"));
           // QRCode qrCode=new QRCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
