package cn.com.jero.mynutzdeom;

import cn.com.jero.mynutzdeom.resultUtil.ImageUtil;
import cn.com.jero.mynutzdeom.resultUtil.OperImg;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2016/12/7.
 */
public class test7 {
    public static void main(String[] args) throws Exception {
        //标题
        OperImg operImg =new OperImg();
        ImageUtil imageUtil=new ImageUtil();
        imageUtil.compressImage("D:\\haozi.png","D:\\haozi.png",764,1250);//指定图片长宽高
     /*   imageUtil.compressImage("D:\\zhangwei.jpg","D:\\zhangwei.jpg",157,157);
        imageUtil.compressImage("D:\\zhaoya.jpg","D:\\zhaoya.jpg",157,157);
        imageUtil.compressImage("D:\\daihao.jpg","D:\\daihao.jpg",157,157);
*/
        String[] words={"来呀，","快活呀，","反正有大把时间"};
        BufferedImage readImage = ImageIO.read(new FileInputStream("D:\\haozi.png"));
        /**左上角*/
        operImg.mergeBothImageTopleftcorner("D:\\haozi.png","D:\\head.jpg","D:\\haozi1.png");
        /**右下角**/
        operImg.mergeBothImageRightbottom("D:\\haozi1.png","D:\\head.jpg","D:\\haozi1.png");
     /*   //右上角
        operImg.mergeBothImageToprightcorner("D:\\haozi1.png","D:\\zhangwei.jpg","D:\\haozi1.png");
        //右下角
        operImg.mergeBothImageRightbottom("D:\\haozi1.png","D:\\zhaoya.jpg","D:\\haozi1.png");*/
       Color color1= new Color(240,118,127);
        operImg.alphaWords2Image("D:\\haozi1.png",1,"黑体",
                Font.BOLD,72,color1,"忘了爱",40,readImage.getHeight()/10*7+10,"png","D:\\haozi1.png");

       /* if(words.length!=0){
            for(int i=1;i<3;i++){
                operImg.alphaWords2Image("D:\\haozi1.png",1,"黑体",
                        Font.BOLD,45,
                        color1,words[i],43+(i-1)*160,readImage.getHeight()/10*7+80+16,"png","D:\\haozi1.png");
            }*/

            operImg.alphaWords2Image("D:\\haozi1.png",1,"黑体",
                    Font.BOLD,45,
                    color1,"来呀,",43+(1-1)*160,readImage.getHeight()/10*7+80+16,"png","D:\\haozi1.png");
        operImg.alphaWords2Image("D:\\haozi1.png",1,"黑体",
                Font.BOLD,45,
                color1,"快活呀,",43+(2-1)*160,readImage.getHeight()/10*7+80+16,"png","D:\\haozi1.png");
        operImg.alphaWords2Image("D:\\haozi1.png",1,"黑体",
                Font.BOLD,45,
                color1,"反正有大把时间",43+(3-1)*160,readImage.getHeight()/10*7+80+16,"png","D:\\haozi1.png");
            operImg.alphaWords2Image("D:\\haozi1.png",1,"黑体",
                    Font.BOLD,45,
                    color1,"重金求子(0551-41578945)",43,readImage.getHeight()/10*7+70*2+25,"png","D:\\haozi1.png");
            operImg.alphaWords2Image("D:\\haozi1.png",1,"黑体",
                    Font.BOLD,45,
                    color1,"过去的就让他过去",43,readImage.getHeight()/10*7+70*3+25,"png","D:\\haozi1.png");
        //}
    }
}
