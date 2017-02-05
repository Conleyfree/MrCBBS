package com.MrCBBS.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private Integer mid;

    private String senderid;

    private char sendertype;

    private String content;

    private String receiverid;

    private String rptobjectid;

    private char rptobjecttype;

    private char isread;

    private String senddate;

    public Message(String senderid, char sendertype, String content, String receiverid, String rptobjectid,char rptobjecttype){
        this.senderid = senderid;
        this.sendertype = sendertype;
        this.content = content;
        this.receiverid = receiverid;
        this.rptobjectid = rptobjectid;
        this.rptobjecttype = rptobjecttype;
        this.isread = '0';
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        this.senddate = df.format(new Date());
        System.out.println(senddate);                // new Date()为获取当前系统时间
    }

    public Integer getMid() {
        return mid;
    }

    public String getSenderid() {
        return senderid;
    }

    public char getSendertype() {
        return sendertype;
    }

    public String getContent() {
        return content;
    }

    public String getReceiverid() {
        return receiverid;
    }

    public char getRptobjecttype() {
        return rptobjecttype;
    }

    public char getIsread() {
        return isread;
    }

    public String getSenddate() {
        return senddate;
    }

}