package com.MrCBBS.entities;

public class Appraise4post {
    private Long pid;

    private Short value;

    private String uid;
    public Appraise4post() {

    }
    public Appraise4post(Long pid, Short value, String uid) {
        this.pid = pid;
        this.value = value;
        this.uid = uid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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