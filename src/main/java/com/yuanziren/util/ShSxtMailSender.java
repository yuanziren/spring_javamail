package com.yuanziren.util;


import com.yuanziren.MyAuthenticator;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 简单封装邮件发送器 发送邮件实现
 * @author lp
 *
 */
public class ShSxtMailSender {

    public void sendHtmlMail(ShSxtMailSendInfo mailSendInfo) {
        Message message = null;
        Session session = null;
        try {
            MyAuthenticator au = new MyAuthenticator(mailSendInfo.getUserName(), mailSendInfo.getUserPwd());
            Properties props = new Properties();
            // 163 邮件服务器地址
            props.put("mail.smtp.host", mailSendInfo.getServerHost());
            // 163 邮件服务器端口
            props.put("mail.smtp.port", mailSendInfo.getServerPort());
            // 163 邮件服务器认证属性 
            props.put("mail.smtp.auth", mailSendInfo.getFlag());
            session = Session.getDefaultInstance(props, au);
            message = new MimeMessage(session);
            Address from = new InternetAddress(mailSendInfo.getFromAddress());
            message.setFrom(from);
            message.setSentDate(new Date());
            if (null != mailSendInfo.getToAddress() && mailSendInfo.getToAddress().size() > 0) {
                Address[] addresses = new Address[mailSendInfo.getToAddress().size()];
                for (int i = 0; i < mailSendInfo.getToAddress().size(); i++) {
                    Address address = new InternetAddress(mailSendInfo.getToAddress().get(i));
                    addresses[i] = address;
                }
                message.setRecipients(Message.RecipientType.TO, addresses);// 设置接收人地址
                message.setSubject(mailSendInfo.getSubject());
                Multipart multipart = new MimeMultipart();
                BodyPart bodyPart = new MimeBodyPart();
                bodyPart.setContent(mailSendInfo.getContent(), "text/html;charset=utf-8");
                multipart.addBodyPart(bodyPart);
                // 附件添加
                List<String> files = mailSendInfo.getAttachFileNames();
                if (null != files && files.size() > 0) {
                    for (int i = 0; i < files.size(); i++) {
                        File tempFile = new File(files.get(i));
                        if (tempFile.exists()) {
                            BodyPart temp = new MimeBodyPart();
                            temp.setDataHandler(new DataHandler(new FileDataSource(tempFile)));
                            temp.setFileName(MimeUtility.encodeText(tempFile.getName()));//设置文件名
                            multipart.addBodyPart(temp);//添加附件
                        }
                    }
                }
                // 设置邮件内容
                message.setContent(multipart);
                Transport.send(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}