package cn.com.jero.mynutzdeom;

import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/29.
 */
public class MapValueUtil {
    public static String getString(Map<String, Object> map, String key) {
        Object obj = getObject(map, key);
        if (null == obj) {
            return "";
        }

        if (obj instanceof String) {
            return obj.toString();
        }

        return "";
    }

    public static Integer getInteger(Map<String, Object> map, String key) {
        Object obj = getObject(map, key);
        if (null == obj) {
            return null;
        }

        if (obj instanceof Integer) {
            return (Integer) obj;
        }

        if (obj instanceof String) {
            return Integer.valueOf(obj.toString());
        }

        return null;
    }

    public static Date getDate(Map<String, Object> map, String key) {
        Object obj = getObject(map, key);
        if (null == obj) {
            return null;
        }

        if (obj instanceof Date) {
            return (Date) obj;
        }

        return null;
    }

    public static Float getFloat(Map<String, Object> map, String key) {
        Object obj = getObject(map, key);
        if (null == obj) {
            return null;
        }

        if (obj instanceof Float) {
            return (Float) obj;
        }

        return null;
    }

    public static Double getDouble(Map<String, Object> map, String key) {
        Object obj = getObject(map, key);
        if (null == obj) {
            return null;
        }

        if (obj instanceof Double) {
            return (Double) obj;
        }

        if (obj instanceof Float) {
            return Double.parseDouble(obj.toString());
        }

        if (obj instanceof Integer) {
            return Double.parseDouble(obj.toString());
        }

        return null;
    }

    public static Object getObject(Map<String, Object> map, String key) {
        if (null == map || StringUtils.isEmpty(key)) {
            return null;
        }

        return map.get(key);
    }



    /**
     * asciicode 转为中文
     *
     * @param asciicode eg:{"code":400002,"msg":"\u7b7e\u540d\u9519\u8bef"}
     * @return eg:{"code":400002,"msg":"签名错误"}
     */
    public static String ascii2native(String asciicode) {
        String[] asciis = asciicode.split("\\\\u");
        String nativeValue = asciis[0];
        try {
            for (int i = 1; i < asciis.length; i++) {
                String code = asciis[i];
                nativeValue += (char) Integer.parseInt(code.substring(0, 4), 16);
                if (code.length() > 4) {
                    nativeValue += code.substring(4, code.length());
                }
            }
        } catch (NumberFormatException e) {
            return asciicode;
        }
        return nativeValue;
    }
}
