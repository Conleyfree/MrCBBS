package com.MrCBBS.entities;

public class Appraise4com {
    private Long cid;

    private Short value;

    private String uid;

    public Appraise4com() {

    }

    public Appraise4com(Long cid, Short value, String uid) {
        this.cid = cid;
        this.value = value;
        this.uid = uid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}