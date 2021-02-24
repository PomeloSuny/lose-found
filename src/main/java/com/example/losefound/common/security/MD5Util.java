package com.example.losefound.common.security;

import java.security.MessageDigest;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 15:07
 */
public class MD5Util {
    public  static  final String SIGN_KEY="sign_key";//签名key

    public static  final  String PARAMETER_KEY="parameter_key";//拼装的参数key
    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /***
     * 对请求的参数排序，生成定长的签名
     * @param  sign  排序后的字符串
     * @param
     * */
    public static String md5Signature(String sign){
        String result ="";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");             /**MD5加密，输出一个定长信息摘要*/
            result = byte2hex(md.digest(sign.toString().getBytes("utf-8")));

        } catch (Exception e) {
            throw new RuntimeException("sign error !");
        }
        return result;
    }


    /**
     * 二行制转字符串
     */
    private static String byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs.append("0").append(stmp);
            else
                hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }
}
