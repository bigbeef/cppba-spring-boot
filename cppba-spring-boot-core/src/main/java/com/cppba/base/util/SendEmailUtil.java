package com.cppba.base.util;

import com.cppba.base.constant.Globals;
import org.apache.commons.lang3.StringUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * 
 *
 * SendEmail
 * 邮件发送工具类
 * 
 * 2015-12-4 下午04:22:03
 * 
 * @version 1.0.0
 *
 */
public class SendEmailUtil {
	
    //发送邮件
	public static boolean sendEmail(String toUserEmail/*收件人*/,String subject/*标题*/,String content/*正文*/,String file/*发送附件*/,String fileName/*附件名*/){
		try {
			final Properties mailProps = new Properties();
			mailProps.put("mail.smtp.auth", "true");
			mailProps.put("username", Globals.EMAIL_USERNAME);
			mailProps.put("password", Globals.EMAIL_PASSWORD);
			mailProps.put("mail.smtp.host", Globals.EMAIL_SMTP);
			
			 // 构建授权信息，用于进行SMTP进行身份验证
	        Authenticator auth = new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                // 用户名、密码
	                String userName = mailProps.getProperty("username");
	                String password = mailProps.getProperty("password");
	                return new PasswordAuthentication(userName, password);
	            }
	        };
			Session mailSession = Session.getInstance(mailProps, auth);
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(Globals.EMAIL_USERNAME));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toUserEmail));
			message.setSubject(subject);
			MimeMultipart multi = new MimeMultipart("related");
			
			MimeBodyPart attach = new MimeBodyPart();  //表示附件
			//附件不为空
			if(StringUtils.isNotBlank(file)){
				attach.setDataHandler(new DataHandler(new FileDataSource(file)));  
		        attach.setFileName( MimeUtility.encodeText(fileName));
		        multi.addBodyPart(attach);
			}
			//添加邮件内容
			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart.setDataHandler(new DataHandler(content, "text/html;charset=UTF-8"));// 网页格式
			multi.addBodyPart(bodyPart);
			
			message.setContent(multi);
			message.saveChanges();
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
