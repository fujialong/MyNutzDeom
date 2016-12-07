package cn.com.jero.mynutzdeom.util;

/**
 * Created by Administrator on 2016/11/21.
 * 验证码校验测试类
 */
public class CheckMsgTest {
    public static void main(String[] args) {
        String mobileNumber = "15155935360";//手机号码
        String code = "5912";//验证码
        try {
            String str = MobileMessageCheck.checkMsg(mobileNumber,code);
            if("success".equals(str)){
                System.out.println("验证成功！");
            }else{
                System.out.println("验证失败！");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
