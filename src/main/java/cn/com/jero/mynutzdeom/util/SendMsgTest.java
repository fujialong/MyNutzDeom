package cn.com.jero.mynutzdeom.util;

/**
 * Created by Administrator on 2016/11/21.
 * 发送验证码测试
 */
public class SendMsgTest {
    public static void main(String[] args) {
        String mobileNumber = "15155935360";//接收验证码的手机号码
        try {
            String str = MobileMessageSend.sendMsg(mobileNumber);
            if("success".equals(str)){
                System.out.println("发送成功！");
            }else{
                System.out.println("发送失败！");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
