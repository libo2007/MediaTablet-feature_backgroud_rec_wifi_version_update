package com.jiaying.mediatablet.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者：lenovo on 2017/1/12 22:45
 * 邮箱：353510746@qq.com
 * 功能：校验工具（ip,端口，手机号，等等的判断是否合法）
 */
public class CheckHelper {

    /**
     * 是否是正确的ip地址
     *
     * @param address
     * @return
     */
    public static boolean isIPAddress(String address) {
        if (TextUtils.isEmpty(address) || address.length() < 7 || address.length() > 15) {
            return false;
        }
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pat = Pattern.compile(rexp);
        Matcher mat = pat.matcher(address);
        boolean ipAddress = mat.find();
        return ipAddress;
    }

    /**
     * ip地址的端口号
     *
     * @param port
     * @return
     */
    public static boolean isPort(String port) {
        try {
            int portVal = Integer.parseInt(port);
            if (portVal > 1024 && portVal < 65535) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * 是否是合法的jiaying的蓝牙名字
     *
     * @param name
     * @return
     */
    public static boolean isBlueToothName(String name) {

        if (!TextUtils.isEmpty(name) && name.startsWith("JY")) {
            return true;
        }
        return false;
    }

    /**
     * 是否为正确的人脸通过识别率
     *
     * @param string
     * @return
     */
    public static boolean isFaceRate(String string) {
        try {
            float val = Float.parseFloat(string);
            if (val >= 0.1 && val <= 0.9) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * 人脸上传照片的张数
     *
     * @param size
     * @return
     */
    public static boolean isFaceUploadSize(String size) {
        try {
            int sizeVal = Integer.parseInt(size);
            if (sizeVal > 0 && sizeVal < 10) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }
}
