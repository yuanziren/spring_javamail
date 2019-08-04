package com.yuanziren;

import com.yuanziren.util.ShSxtMailSendInfo;
import com.yuanziren.util.ShSxtMailSender;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SendMailTest {

    @Test
    public void send01() throws Exception {
        new SendMail().send01();
        System.out.println("发送成功");
    }
    @Test
    public void send02() throws Exception {
        new SendMail().send02();
        System.out.println("发送成功");
    }

    @Test
    public void send03() throws Exception {
        new SendMail().send03();
        System.out.println("发送成功");
    }

    @Test
    public void testMail02() {
        ShSxtMailSendInfo shSxtMailSendInfo=new ShSxtMailSendInfo();
        shSxtMailSendInfo.setServerHost("smtp.163.com");
        shSxtMailSendInfo.setServerPort("25");
        shSxtMailSendInfo.setUserName("yuanziren19@163.com");   //邮箱号
        shSxtMailSendInfo.setUserPwd("yuanziren19");    //邮箱授权码
        shSxtMailSendInfo.setSubject("全体邮件");
        shSxtMailSendInfo.setFromAddress("yuanziren19@163.com");  //邮箱号
        shSxtMailSendInfo.setContent("你好同学");
        List<String> users=new ArrayList<String>();
        users.add("yuanziren19@163.com");   //添加用户邮箱

        shSxtMailSendInfo.setToAddress(users);
        // 添加附件
        List<String> files=new ArrayList<String>();
        files.add("C:\\Users\\Administrator\\Desktop\\尚学堂\\04JavaEE高级\\高级第一阶段\\代码\\spring06-email_2\\01.jpg");
        files.add("C:\\Users\\Administrator\\Desktop\\尚学堂\\04JavaEE高级\\高级第一阶段\\代码\\spring06-email_2\\pom.xml");
        files.add("C:\\Users\\Administrator\\Desktop\\尚学堂\\04JavaEE高级\\高级第一阶段\\代码\\spring06-email_2\\src\\test\\java\\com\\shsxt\\SendMailTest.java");
        shSxtMailSendInfo.setAttachFileNames(files);
        ShSxtMailSender mailSender=new ShSxtMailSender();
        mailSender.sendHtmlMail(shSxtMailSendInfo);
    }

}