package base.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态变量
 */
public class Globals {
    private static Logger logger = LoggerFactory.getLogger(Globals.class);
    
    //文件上传路径
    public static String getFileSystemPath(){
        //FileSystem是图片服务器的软链接
        return "../../FileSystem";
    }

    public final  static int USERID = 1;

    //图片服务器地址
    public final static String FILE_SERVER_URL ="http://image.cppba.com";

    //email
    public final static String EMAIL_USERNAME="Service01@51dong.cc"/*"5k72@wukow.com"*/;//发送人用户名
    public final static String EMAIL_PASSWORD="Service.01"/*"wkwl2014"*/;//发送人密码
    public final static String EMAIL_SMTP="smtp.mxhichina.com"/*"smtp.exmail.qq.com"*/;//邮件服务器smtp
    public final static String EMAIL_SERVER="Service01@51dong.cc";//接收通知


    //aliyun-oss
    public final static String ENDPOINT = "http://oss-cn-hongkong.aliyuncs.com";
    public final static String ACCESSKEYID = "KCsxSw9uWTJSz90h";
    public final static String ACCESSKEYSECRET = "JMlEEkI3nlXF1rkdBDzk9RtH1X5aD3";
    public final static String BUCKETNAME = "hk-filesystem";

    //前端模板文件夹
    public final static String TEMPLATE_TYPE = "default";
}
