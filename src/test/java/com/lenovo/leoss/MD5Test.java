package com.lenovo.leoss;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by zhangyl27 on 2014/10/16.
 */
public class MD5Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "bill_yunlong@163.com"+new Date().getTime();
        String strAfMD5 = DigestUtils.md5DigestAsHex(str.getBytes("utf-8"));
        System.out.printf(str+"<===MD5===>"+strAfMD5);
    }

}
