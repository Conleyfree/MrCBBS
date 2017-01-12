package com.MrCBBS.entities;

public class Admin extends AdminKey {
    private String apasswd;

    public String getApasswd() {
        return apasswd;
    }

    public void setApasswd(String apasswd) {
        this.apasswd = apasswd == null ? null : apasswd.trim();
    }
}