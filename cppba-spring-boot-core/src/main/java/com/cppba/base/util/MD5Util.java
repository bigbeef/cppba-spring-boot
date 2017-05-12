package com.cppba.base.util;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

public class MD5Util {
    /**
     * Md5 32位小写 加密
     * @param source
     * @return
     * @throws Exception
     */
    public static String encode32Md5(String source) throws Exception{
        if(StringUtils.isEmpty(source)){
            return null;
        }
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((source).getBytes("UTF-8"));
        byte b[] = md5.digest();

        int i;
        StringBuffer buf = new StringBuffer("");

        for(int offset=0; offset<b.length; offset++){
            i = b[offset];
            if(i<0){
                i+=256;
            }
            if(i<16){
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }
        return buf.toString();
    }
}
