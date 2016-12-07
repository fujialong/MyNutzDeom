package cn.com.jero.mynutzdeom;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/30.
 */
public class test4 {
    InputStream is = null;
    Properties dbProps = null;
    public  void  Stweek() {
        // TODO Auto-generated constructor stub
        is = getClass().getResourceAsStream("/config.properties");
        dbProps = new Properties();
        try {
            dbProps.load(is);
        }
        catch (Exception e) {
            System.err.println("不能读取属性文件. " +
                    "请确保db.properties在CLASSPATH指定的路径中");
        }
    }
    public String getStartdate()
    {
        String sd = null;
        sd = dbProps.getProperty("startdate");
        return sd;
    }
    public String getTotalweek()
    {
        String totalweek=null;
        totalweek = dbProps.getProperty("totalweek");
        return totalweek;
    }

    public static void main(String[] args) {
        test4 t=new test4();
        t.Stweek();
    }
}
