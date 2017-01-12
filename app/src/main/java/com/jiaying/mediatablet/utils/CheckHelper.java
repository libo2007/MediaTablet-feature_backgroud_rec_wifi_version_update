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
     * 该正则表达式可以匹配所有的数字 包括负数
     *
     * @param string
     * @return
     */
    public static boolean isNumeric(String string) {
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]+");
        String bigStr;
        try {
            bigStr = new BigDecimal(string).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }
        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 人脸上传照片的张数
     * @param size
     * @return
     */
    public static boolean isFaceUploadSize(String size) {
        try {
            int sizeVal = Integer.parseInt(size);
            if (sizeVal > 0 && sizeVal < 20) {
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }
}
