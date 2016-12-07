package cn.com.jero.mynutzdeom.modules;

import cn.com.jero.mynutzdeom.common.Result;
import cn.com.jero.mynutzdeom.util.DateUtil;
import cn.com.jero.mynutzdeom.util.ExifUtil;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.lang.random.R;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.impl.AdaptorErrorContext;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Wizzer on 2016/7/5.
 */
@IocBean
@At("mynutzdeom/uploadController/file/upload")
public class UploadController {
    private static final Log log = Logs.get();

    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:imageUpload"})
    @POST
    @At
    @Ok("json")
    public Object image(@Param("filedate") TempFile tf, HttpServletRequest req, AdaptorErrorContext err) {
        Map<String,String> map=new HashMap<String,String>();
        try {
            if (err != null && err.getAdaptorErr() != null) {
                return NutMap.NEW().addv("code", 1).addv("msg", "文件不合法");
            } else if (tf == null) {
                return Result.error("空文件");
            } else {
                String f = "/upload" + "/image/" + DateUtil.format(new Date(), "yyyyMMdd")+"/";
                String realpathdir = req.getSession().getServletContext()
                        .getRealPath(f);
                File savedir = new File(realpathdir);
                // 如果目录不存在就创建
                if (!savedir.exists()) {
                    savedir.mkdirs();
                }
                String uur= R.UU32();
                String uploadAddress = realpathdir +uur+ tf.getSubmittedFileName().substring(tf.getSubmittedFileName().indexOf("."));
                Files.write(new File(uploadAddress), tf.getInputStream());

                //读取地址
                Properties prop = new Properties();
                String baseUrl="";
                try {
                    InputStream in= getClass().getResourceAsStream("/config.properties");
                    prop.load(in);
                    baseUrl = prop.getProperty("baseUrl").trim();
                } catch (IOException e) {
                    e.printStackTrace();
                }
               // ExifUtil exifUtil=new ExifUtil();
               // exifUtil.doIt(uploadAddress);
                //System.out.println("返回路径："+baseUrl+f+uur+tf.getSubmittedFileName().substring(tf.getSubmittedFileName().indexOf(".")));
                return Result.success("上传成功", baseUrl+f+uur+tf.getSubmittedFileName().substring(tf.getSubmittedFileName().indexOf(".")));
            }
        } catch (Exception e) {
            return Result.error("系统错误");
        } catch (Throwable e) {
            return Result.error("图片格式错误");
        }
    }
}
