package cn.com.jero.mynutzdeom.modules;

import cn.com.jero.mynutzdeom.resultUtil.*;
import cn.com.jero.mynutzdeom.util.DateUtil;
import cn.com.jero.mynutzdeom.util.DecodeTest;
import cn.com.jero.mynutzdeom.util.TextToFile;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import org.nutz.http.Http;
import org.nutz.lang.random.R;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.repo.Base64;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HomeModule extends BaseModule {

    /**Wap网关Via头信息中特有的描述信息*/
    private static String mobileGateWayHeaders[]=new String[]{
    "ZXWAP",//中兴提供的wap网关的via信息，例如：Via=ZXWAP GateWayZTE Technologies，
            "chinamobile.com",//中国移动的诺基亚wap网关，例如：Via=WTP/1.1 GDSZ-PB-GW003-WAP07.gd.chinamobile.com (Nokia WAP Gateway 4.1 CD1/ECD13_D/4.1.04)
           "monternet.com",//移动梦网的网关，例如：Via=WTP/1.1 BJBJ-PS-WAP1-GW08.bj1.monternet.com. (Nokia WAP Gateway 4.1 CD1/ECD13_E/4.1.05)
            "infoX",//华为提供的wap网关，例如：Via=HTTP/1.1 GDGZ-PS-GW011-WAP2 (infoX-WISG Huawei Technologies)，或Via=infoX WAP Gateway V300R001 Huawei Technologies
            "XMS 724Solutions HTG",//国外电信运营商的wap网关，不知道是哪一家
            "wap.lizongbo.com",//自己测试时模拟的头信息
            "Bytemobile",//貌似是一个给移动互联网提供解决方案提高网络运行效率的，例如：Via=1.1 Bytemobile OSN WebProxy/5.1
    };

    /**电脑上的IE或Firefox浏览器等的User-Agent关键词*/
    private static String[] pcHeaders=new String[]{
    "Windows 98",
     "Windows ME",
     "Windows 2000",
      "Windows XP",
      "Windows NT",
       "Ubuntu"
};

    /**手机浏览器的User-Agent里的关键词*/
    private static String[] mobileUserAgents=new String[]{"Nokia","SAMSUNG", "MIDP-2","CLDC1.1", "SymbianOS", "MAUI", "UNTRUSTED/1.0", "Windows CE", "iPhone", "iPad", "Android","BlackBerry", "UCWEB", "ucweb", "BREW", "J2ME", "YULONG", "YuLong", "COOLPAD", "TIANYU", "TY-", "K-Touch", "Haier", "DOPOD", "Lenovo", "LENOVO", "HUAQIN", "AIGO-", "CTC/1.0", "CTC/2.0", "CMCC", "DAXIAN", "MOT-", "SonyEricsson", "GIONEE", "HTC", "ZTE", "HUAWEI", "webOS", "GoBrowser", "IEMobile", "WAP2.0"};


    private static final Log log = Logs.get();

    public static String baseUrl="";


    @At("mynutzdeom/home/index")
    @Ok("jsp:jsp.home.upload")
    @GET
    public void testUpload() {
        log.info("HomeModule#index");
    }

    @At("mynutzdeom/index")
    @Ok("jsp:jsp.index")
    @GET
    public void index() {
        log.info("HomeModule#test");
    }



    @At("mynutzdeom/home/upload")
    @Ok("json")
    @GET
    public void upload(@Param("word[]") String[] word[]) {
        System.out.println(word);
        log.info("HomeModule#test");
    }

/*    @At("mynutzdeom/home/moble/index")
    @Ok("jsp:jsp.mobile.index")
    @GET
    public void mobileIndex(@Param("word[]") String[] word[]) {
        System.out.println(word);
        log.info("HomeModule#test");
    }*/


    /**获取背景图片**/
    @At("mynutzdeom/home/getMask")
    @Ok("raw:png")
    public Object getMask(@Param("word[]") String[] word, String gender, String identity , int color, HttpServletRequest request) throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();

        String f = "/upload" + "/image/" + DateUtil.format(new Date(), "yyyyMMdd")+"/";
        String realpathdir = request.getSession().getServletContext()
                .getRealPath(f);
        File savedir = new File(realpathdir);
        // 如果目录不存在就创建
        if (!savedir.exists()) {
            savedir.mkdirs();
        }
        Color color1=null;
            if (color==1){//粉色
                color1=new Color(240,118,127);
            }
            if (color==2){
                color1=new Color(253,186,125);
            }
            if (color==3){
                color1=new Color(251,219,131);
            }
            if (color==4){
                color1=new Color(221,236,150);
            }
            if (color==5){
                color1=new Color(159,232,241);
            }
            if (color==6){
                color1=new Color(147,152,244);
            }
            if (color==7){
                color1=new Color(175,160,222);
            }
            String title="";
            if(null!=gender&&gender.equals("1")){
                   title="我是体育达人";
            }
            if(null!=gender&&gender.equals("2")){
                title="我是文化达人";
            }
        //画图
        DrawTranslucentPng drawTranslucentPng=new DrawTranslucentPng();
        BufferedImage imgMap =drawTranslucentPng.drawTranslucentStringPic(232, 380, 30,title,word, request.getSession().getServletContext().getRealPath("/img"),color1);
        return imgMap;
    }

    /**生成预览图片*/
    @At("mynutzdeom/home/getInfo")
    @Ok("json")
    public Object getInfo(HttpServletRequest request)throws Exception{
        //保存图片
        String f = "/upload" + "/image/" + DateUtil.format(new Date(), "yyyyMMdd");//文件夹
        String realpathdir = request.getSession().getServletContext().getRealPath(f);//真实路径
        String uucode=R.UU32();
        String imgPath=realpathdir+"/"+uucode+".png";//真实图片存放地址
        String newChangeAddress=R.UU32();
        String netPath="/"+uucode+".png";

            String reads=readInputString(request);//读取总的字符串
            String newStringImg=readRquest(reads);//得到图片流字符串
            //读取流获得底图
            GenerateImage2(newStringImg,imgPath,realpathdir+"/"+newChangeAddress+".png",request);
            //最终返回给客户端的图片相对地址
            String returnImgAddress=f+"/"+newChangeAddress+".png";
            //图片操作类
            OperImg operImg =new OperImg();
            //原图路径，底图路径，合成路径
            /**左上角*/
            operImg.mergeBothImageTopleftcorner(realpathdir+"/"+newChangeAddress+".png",request.getSession().getServletContext().getRealPath("/img/wentitong6.png"),realpathdir+"/"+newChangeAddress+".png");
            /**右下角**/
            operImg.mergeBothImageRightbottom(realpathdir+"/"+newChangeAddress+".png",request.getSession().getServletContext().getRealPath("/img/Qcode6.png"),realpathdir+"/"+newChangeAddress+".png");

            //写入文字
            /**获取文字*/
            Map<String,Object> propMap= getInputProperty(reads);

            String[] words= (String[]) propMap.get("words");//文字
            Color color1=null;
            String[] colors= (String[]) propMap.get("color");//颜色
            if(colors.length!=0){
                if (colors[1].equals("1")){//粉色
                    color1=new Color(240,118,127);
                }
                if (colors[1].equals("2")){
                    color1=new Color(253,186,125);
                }
                if (colors[1].equals("3")){
                    color1=new Color(251,219,131);
                }
                if (colors[1].equals("4")){
                    color1=new Color(221,236,150);
                }
                if (colors[1].equals("5")){
                    color1=new Color(159,232,241);
                }
                if (colors[1].equals("6")){
                    color1=new Color(147,152,244);
                }
                if (colors[1].equals("7")){
                    color1=new Color(175,160,222);
                }
            }
            String gender1= (String) propMap.get("gender");//主题
            String title="";
            if(gender1!=null&&gender1.equals("1")){
                title="我是体育达人";
            }
            if(gender1!=null&&gender1.equals("2")){
                title="我是文化达人";
            }

            //标题
            BufferedImage readImage = ImageIO.read(new FileInputStream(realpathdir+"/"+newChangeAddress+".png"));
            operImg.alphaWords2Image(realpathdir+"/"+newChangeAddress+".png",1,"黑体",
                    Font.BOLD,72,color1,title,40,readImage.getHeight()/10*7+10,"png",realpathdir+"/"+newChangeAddress+".png");

            if(words.length!=0){
                for(int i=1;i<4;i++){
                    operImg.alphaWords2Image(realpathdir+"/"+newChangeAddress+".png",1,"黑体",
                            Font.BOLD,45,
                           color1,words[i],43+(i-1)*160,readImage.getHeight()/10*7+80+16,"png",realpathdir+"/"+newChangeAddress+".png");
                }
                operImg.alphaWords2Image(realpathdir+"/"+newChangeAddress+".png",1,"黑体",
                        Font.BOLD,45,
                        color1,"福田文体通",43,readImage.getHeight()/10*7+70*2+25,"png",realpathdir+"/"+newChangeAddress+".png");
                operImg.alphaWords2Image(realpathdir+"/"+newChangeAddress+".png",1,"黑体",
                        Font.BOLD,45,
                        color1,"方便的不像公众号",43,readImage.getHeight()/10*7+70*3+25,"png",realpathdir+"/"+newChangeAddress+".png");
            }

           // String style= (String) propMap.get("style");//类型
           // ImageIO.write(readImage,"png",new File(realpathdir+"/"+newChangeAddress+"end"+".png"));

        Map<String,Object> map=new HashMap<String,Object>();
        ProduceImgU produceImgU=new ProduceImgU();


        //读取地址
        Properties prop = new Properties();

        try {
            InputStream in= getClass().getResourceAsStream("/config.properties");
            prop.load(in);
            baseUrl = prop.getProperty("baseUrl").trim();
            //System.out.println(baseUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }


        produceImgU.setImage(baseUrl+returnImgAddress);
        produceImgU.setWeiboUrl("");
        produceImgU.setDownload(baseUrl+returnImgAddress);
        map.put("code",0);
        map.put("data",produceImgU);
        return map;
    }

    //base64字符串转化成图片
    public static BufferedImage GenerateImage(String imgStr)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成png图片
            ByteArrayInputStream in = new ByteArrayInputStream(b);    //将b作为输入流；
            BufferedImage image = ImageIO.read(in);     //将in作为输入流，读取图片存入image中，而这里in可以为ByteArrayInputStream();
            return image;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**读取图片流信息(截取)*/
    public static String readRquest(String readString)throws Exception{
           String newStringImg=readString.substring(readString.lastIndexOf("base64,")+7);
           //String decodeUrl =java.net.URLDecoder.decode(newStringImg,"UTF-8");//解码*/
        return newStringImg;
    }
    /**读取流信息*/
    public static String readInputString(HttpServletRequest request)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String decodeUrl =java.net.URLDecoder.decode(sb.toString(),"UTF-8");//解码*/
        return decodeUrl;
    }

    /**base64转数组第二个方法**/
    public static BufferedImage  GenerateImage2(String imgStr,String imgFilePath,String toImgPath,HttpServletRequest request)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return null;
       /// BASE64Decoder decoder = new BASE64Decoder();
        org.apache.commons.codec.binary.Base64 decoder=new org.apache.commons.codec.binary.Base64();
        /**网上查到的问题原因是正确的，我用的Base64转换的流，type是默认的acsii，需要改成binary。
         刚刚仔细比对了一下Base64，里面有个org.apache.commons.codec.binary.Base64，转换时type会设置为binary。用它的decodeBase64(String str)实现了base64转换流的过程，并被火狐浏览器识别*/
        try
        {
            //Base64解码
            //byte[] b = decoder.decodeBuffer(imgStr);
            byte[] b = decoder.decodeBase64(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            //String imgFilePath = "d://222.jpg";//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

           // OperImg operImg =new OperImg();
            //operImg.reduceImageByRatio(imgFilePath,toImgPath,2,2);
            ImageUtil imageUtil=new ImageUtil();
           boolean ismobie= isMobileDevice(request);
            if(!ismobie){//电脑
                imageUtil.compressImage(imgFilePath,toImgPath,764,1250);//指定图片长宽高
            }else{//手机访问
                imageUtil.compressImage(imgFilePath,toImgPath,402,662);//指定图片长宽高
            }

           /* imageUtil.compressImage("D:\\apache-tomcat-9\\webapps\\ROOT\\img\\wentitong3.png","D:\\apache-tomcat-9\\webapps\\ROOT\\img\\wentitong5.png",140,140);
            imageUtil.compressImage("D:\\apache-tomcat-9\\webapps\\ROOT\\img\\Qcode3.png","D:\\apache-tomcat-9\\webapps\\ROOT\\img\\Qcode5.png",170,170);*/
            BufferedImage image = ImageIO.read(new FileInputStream(toImgPath));
         /*   File file=new File(imgFilePath);//删除原图
            file.delete();*/
            return image;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public Map<String,Object> getInputProperty(String sb)throws Exception{
        Map<String,Object>map=new HashMap<String, Object>();
        String subMatherString=sb.substring(0,sb.lastIndexOf("&image"));
        String style=subMatherString.substring(6,7);
        String[] words=subMatherString.substring(subMatherString.indexOf("&word[]"),subMatherString.indexOf("&identity")).split("&word\\[]=");
        String[] color=subMatherString.substring(subMatherString.indexOf("&color=")).split("color=");
        String gender=subMatherString.substring(subMatherString.indexOf("&gender=")).substring(8,9);
        map.put("style",style);
        map.put("words",words);
        map.put("color",color);
        map.put("gender",gender);
        return map;
    }

    /***
     * 判断是手机访问还是电脑访问
     * */

    /**
     * 根据当前请求的特征，判断该请求是否来自手机终端，主要检测特殊的头信息，以及user-Agent这个header
     * @param request http请求
     * @return 如果命中手机特征规则，则返回对应的特征字符串
     */
    public static boolean isMobileDevice(HttpServletRequest request){
        boolean b = false;
        boolean pcFlag = false;
        boolean mobileFlag = false;
        String via = request.getHeader("Via");
        String userAgent = request.getHeader("user-agent");
        for (int i = 0; via!=null && !via.trim().equals("") && i < mobileGateWayHeaders.length; i++) {
            if(via.contains(mobileGateWayHeaders[i])){
                mobileFlag = true;
                break;
                }
           }
        for (int i = 0;!mobileFlag && userAgent!=null && !userAgent.trim().equals("") && i < mobileUserAgents.length; i++) {
            if(userAgent.contains(mobileUserAgents[i])){
                mobileFlag = true;
                break;
                }
            }
        for (int i = 0; userAgent!=null && !userAgent.trim().equals("") && i < pcHeaders.length; i++) {
            if(userAgent.contains(pcHeaders[i])){
                pcFlag = true;
                break;
                }
            }
        if(mobileFlag==true && pcFlag==false){
            b=true;
            }
        return b;//false pc true shouji

    }


}
