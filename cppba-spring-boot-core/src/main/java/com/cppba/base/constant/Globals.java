package com.cppba.base.constant;

import com.cppba.base.util.ConfigUtil;

/**
 * 静态变量
 */
public class Globals {

    //系统应用户ID
    public final  static int USER_ID = ConfigUtil.getInteger("USER_ID",1);

    //图片本地地址
    public final static String FILE_SYSTEM_PATH = ConfigUtil.getString("FILE_SYSTEM_PATH","../../FileSystem");
    //图片服务器地址
    public final static String FILE_SERVER_URL = ConfigUtil.getString("FILE_SERVER_URL","http://image.cppba.com");

    /**
     *   email
     */
    //发送人用户名
    public final static String EMAIL_USERNAME = ConfigUtil.getString("EMAIL_USERNAME","Service01@51dong.cc");
    //发送人密码
    public final static String EMAIL_PASSWORD =ConfigUtil.getString("EMAIL_PASSWORD","Service.01");
    //邮件服务器smtp
    public final static String EMAIL_SMTP =ConfigUtil.getString("EMAIL_SMTP","smtp.mxhichina.com");
    //接收通知
    public final static String EMAIL_SERVER = ConfigUtil.getString("EMAIL_SERVER","Service01@51dong.cc");


    //aliyun-oss
    public final static String ENDPOINT = ConfigUtil.getString("ENDPOINT","http://oss-cn-hongkong.aliyuncs.com");
    public final static String ACCESSKEYID = ConfigUtil.getString("ACCESSKEYID","KCsxSw9uWTJSz90h");
    public final static String ACCESSKEYSECRET = ConfigUtil.getString("ACCESSKEYSECRET","JMlEEkI3nlXF1rkdBDzk9RtH1X5aD3");
    public final static String BUCKETNAME = ConfigUtil.getString("BUCKETNAME","hk-filesystem");

    //前端模板文件夹
    public final static String TEMPLATE_TYPE = ConfigUtil.getString("TEMPLATE_TYPE","default");

    //通用静态资源地址,如:jquery、bootstrap
    public final static String STATIC_PUBLIC_URL = ConfigUtil.getString("STATIC_PUBLIC_URL","http://127.0.0.1/public-static");

    //项目资源地址
    public final static String STATIC_PRIVATE_URL = ConfigUtil.getString("STATIC_PRIVATE_URL","http://127.0.0.1/cppba-spring-boot-static");
}
