package cn.com.jero.mynutzdeom;

import java.awt.*;

/**
 * Created by Administrator on 2016/11/30.
 */
public class test1 {
    public static void main(String[] agrs)
    {
        //获取系统中可用的字体的名字
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontName = e.getAvailableFontFamilyNames();
        for(int i = 0; i<fontName.length ; i++)
        {
            System.out.println(fontName[i]);
        }
    }
}
