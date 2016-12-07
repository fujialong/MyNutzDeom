package cn.com.jero.mynutzdeom.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */
public class Regedit {
    public static void regist(final String strAccid, final String strPassword) {

        new Thread() {
            @Override
            public void run() {
                try
                {
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    String url = "https://api.netease.im/nimserver/user/create.action";
                    HttpPost httpPost = new HttpPost(url);

                    String appKey = "7108e284836eb7700ead360531b2ba4a";
                    String appSecret = "05100aa2933c";
                    String nonce =  "12345";
                    String curTime = String.valueOf((new Date()).getTime() / 1000L);
                    String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码

                    // 设置请求的header
                    httpPost.addHeader("AppKey", appKey);
                    httpPost.addHeader("Nonce", nonce);
                    httpPost.addHeader("CurTime", curTime);
                    httpPost.addHeader("CheckSum", checkSum);
                    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

                    // 设置请求的参数
                    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                    nvps.add(new BasicNameValuePair("accid", strAccid));
                    nvps.add(new BasicNameValuePair("token", strPassword));
                    httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

                    // 执行请求
                    HttpResponse response = httpClient.execute(httpPost);

                    String strRes = EntityUtils.toString(response.getEntity(), "utf-8");
                    // 打印执行结果
                    System.out.println(strRes);
                }catch(Exception e)
                {
                    String strError = e.toString();
                    strError = "";
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        regist("fujialong","123123");
    }
}
