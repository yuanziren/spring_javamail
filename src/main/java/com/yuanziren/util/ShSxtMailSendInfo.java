package com.yuanziren.util;

import java.util.List;

/**
 * 邮件发送信息类
 *   定义发送邮件时 邮件服务器  端口 发送方用户名 密码等字段
 * @author lp
 *
 */
public class ShSxtMailSendInfo {
    
    private String serverHost;// 服务器主机
    private String serverPort;//服务器端口
    private String fromAddress;//发送方邮箱地址
    private List<String> toAddress;// 接收方邮箱地址
    
    private String userName;//邮件服务器用户名
    private String userPwd;//邮件服务器密码
    
    private String subject;//邮件主题
    private String content;// 邮件内容
    
    
    private String flag="true";
    
    private List<String> attachFileNames;//附件文件名

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public List<String> getToAddress() {
        return toAddress;
    }

    public void setToAddress(List<String> toAddress) {
        this.toAddress = toAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(List<String> attachFileNames) {
        this.attachFileNames = attachFileNames;
    }
}