package com.yuanziren.test;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class SimpleOrderManager implements OrderManager {


    private JavaMailSenderImpl mailSender;
    private SimpleMailMessage templateMessage;

    @Override
    public void placeOrder() {

        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);

        msg.setTo("yuanziren19@163.com");
        msg.setText("通过Spring 发送....");

        this.mailSender.send(msg);

    }

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }
}
