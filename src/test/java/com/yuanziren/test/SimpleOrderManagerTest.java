package com.yuanziren.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.File;

import static org.junit.Assert.*;

public class SimpleOrderManagerTest {
    @Test
    public void placeOrder() throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
        SimpleOrderManager order = (SimpleOrderManager) context.getBean("orderManager");
        order.placeOrder();

    }

    @Test
    public void placeOrder02() throws Exception {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring.xml");

        JavaMailSender mailSender= (JavaMailSender) ac.getBean("mailSender");

        MimeMessage message= mailSender.createMimeMessage();
        message.setSubject("spring_mail");
// 创建带有附件的消息帮组类
        MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
        helper.setTo(new InternetAddress("yuanziren19@163.com"));//设置接收人
        helper.setText("Thank you for ordering!");
        helper.setFrom("yuanziren19@163.com");
        helper.addAttachment("01.jpg", new File("C:\\Users\\Administrator\\Desktop\\尚学堂\\04JavaEE高级\\高级第一阶段\\代码\\spring06-email_3\\01.jpg"));
        mailSender.send(message);

    }
}