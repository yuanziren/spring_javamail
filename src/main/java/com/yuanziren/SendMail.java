package com.yuanziren;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SendMail {

    public void send01() throws MessagingException {
        /***
         * 1. 邮件基本配置
         * 2. 定义邮件内容
         * 3. 发送邮件
         * */

        // 1. 邮件基本配置
        // 定义邮箱服务器配置
        Properties props=new Properties();
        // 163 邮件服务器地址
        props.put("mail.smtp.host", "smtp.163.com");
        // 163 邮件服务器端口
        props.put("mail.smtp.port", "25");
        // 163 邮件服务器认证属性
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new MyAuthenticator("yuanziren19@163.com", "yuanziren19"));//这个不是密码，是授权码，需要通过163邮箱设置

        //2. 定义邮件内容
        Message message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress("yuanziren19@163.com"));
        // 收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("yuanziren19@163.com"));
        // 发送日期
        message.setSentDate(new Date());
        // 发送主题
        message.setSubject("普通文本邮件");
        // 发送内容
        message.setText("我是一封普通的文本邮件");

        //3. 发送邮件
        Transport.send(message);
    }

    public void send02() throws MessagingException {
        /***
         * 1. 邮件基本配置
         * 2. 定义邮件内容
         * 3. 发送邮件
         * */

        // 1. 邮件基本配置
        // 定义邮箱服务器配置
        Properties props=new Properties();
        // 163 邮件服务器地址
        props.put("mail.smtp.host", "smtp.163.com");
        // 163 邮件服务器端口
        props.put("mail.smtp.port", "25");
        // 163 邮件服务器认证属性
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new MyAuthenticator("yuanziren19@163.com", "yuanziren19"));

        //2. 定义邮件内容
        Message message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress("yuanziren19@163.com"));
        // 收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("yuanziren19@163.com"));
        // 发送日期
        message.setSentDate(new Date());
        // 发送主题
        message.setSubject("普通html邮件");
        // 发送内容

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(
                "<html><body><a href='http://www.baidu.com'>百度一下</a></body></html>",
                "text/html;charset=utf-8");

        multipart.addBodyPart(bodyPart);
        message.setContent(multipart);

        //3. 发送邮件
        Transport.send(message);
    }

    public void send03() throws MessagingException, UnsupportedEncodingException {
        /***
         * 1. 邮件基本配置
         * 2. 定义邮件内容
         * 3. 发送邮件
         * */

        // 1. 邮件基本配置
        // 定义邮箱服务器配置
        Properties props=new Properties();
        // 163 邮件服务器地址
        props.put("mail.smtp.host", "smtp.163.com");
        // 163 邮件服务器端口
        props.put("mail.smtp.port", "25");
        // 163 邮件服务器认证属性
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new MyAuthenticator("yuanziren19@163.com", "yuanziren19"));

        //2. 定义邮件内容
        Message message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress("yuanziren19@163.com"));
        // 收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("yuanziren19@163.com"));
        // 发送日期
        message.setSentDate(new Date());
        // 发送主题
        message.setSubject("普通html邮件");
        // 发送内容

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(
                "<html><body><a href='http://www.baidu.com'>百度一下</a></body></html>",
                "text/html;charset=utf-8");

        multipart.addBodyPart(bodyPart);



        MimeBodyPart bodyPart02 = new MimeBodyPart();
        FileDataSource fileDataSource =
                new FileDataSource(new File("E:\\java_27\\spring06-email\\pom.xml"));
        bodyPart02.setDataHandler(new DataHandler(fileDataSource));
        bodyPart02.setFileName(MimeUtility.encodeText("pom.xml"));
        multipart.addBodyPart(bodyPart02);

        MimeBodyPart bodyPart03 = new MimeBodyPart();
        FileDataSource fileDataSource03 =
                new FileDataSource(new File("E:\\java_27\\spring06-email\\01.jpg"));
        bodyPart03.setDataHandler(new DataHandler(fileDataSource03));
        bodyPart03.setFileName(MimeUtility.encodeText("01.jpg"));
        multipart.addBodyPart(bodyPart03);


        message.setContent(multipart);

        //3. 发送邮件
        Transport.send(message);
    }


}
