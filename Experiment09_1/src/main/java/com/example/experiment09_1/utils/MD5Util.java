package com.example.experiment09_1.utils;

import java.security.MessageDigest;

/**
 * @author Owem
 * @date 2023/2/24 09:35
 * @description MD5 工具类
 **/
public class MD5Util {
    /**
     * @param password 密码字符串
     * @return java.lang.String
     * @date 2023/3/15 17:14
     * @description 将密码字符串进行 MD5 加盐加密
     */
    public static String encode(String password, String salt) {
        password = password + salt;
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
