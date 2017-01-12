package com.MrCBBS.entities;

import java.util.Date;

public class Applicate {
    private Integer apid;

    private String uid;

    private String reason;

    private Date aptime;

    private String status;

    private Long aid1;

    private String value1;

    private Long aid2;

    private String value2;

    private Long aid3;

    private String value3;

    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getAptime() {
        return aptime;
    }

    public void setAptime(Date aptime) {
        this.aptime = aptime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getAid1() {
        return aid1;
    }

    public void setAid1(Long aid1) {
        this.aid1 = aid1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1 == null ? null : value1.trim();
    }

    public Long getAid2() {
        return aid2;
    }

    public void setAid2(Long aid2) {
        this.aid2 = aid2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2 == null ? null : value2.trim();
    }

    public Long getAid3() {
        return aid3;
    }

    public void setAid3(Long aid3) {
        this.aid3 = aid3;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3 == null ? null : value3.trim();
    }
}