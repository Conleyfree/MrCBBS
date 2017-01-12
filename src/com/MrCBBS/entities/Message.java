package com.MrCBBS.entities;

import java.util.Date;

public class Message {
    private Integer mid;

    private String senderid;

    private String sendertype;

    private String content;

    private String receiverid;

    private Long rptobjectid;

    private String rptobjecttype;

    private String isread;

    private Date senddate;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid == null ? null : senderid.trim();
    }

    public String getSendertype() {
        return sendertype;
    }

    public void setSendertype(String sendertype) {
        this.sendertype = sendertype == null ? null : sendertype.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid == null ? null : receiverid.trim();
    }

    public Long getRptobjectid() {
        return rptobjectid;
    }

    public void setRptobjectid(Long rptobjectid) {
        this.rptobjectid = rptobjectid;
    }

    public String getRptobjecttype() {
        return rptobjecttype;
    }

    public void setRptobjecttype(String rptobjecttype) {
        this.rptobjecttype = rptobjecttype == null ? null : rptobjecttype.trim();
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread == null ? null : isread.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }
}