package com.MrCBBS.entities;

import java.util.Date;

public class Report {
    private Integer rid;

    private String defid;

    private String type;

    private String uid;

    private String reason;

    private String status;

    private Date dealtime;

    private String dealmanid;

    private String dealmantype;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getDefid() {
        return defid;
    }

    public void setDefid(String defid) {
        this.defid = defid == null ? null : defid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    public String getDealmanid() {
        return dealmanid;
    }

    public void setDealmanid(String dealmanid) {
        this.dealmanid = dealmanid == null ? null : dealmanid.trim();
    }

    public String getDealmantype() {
        return dealmantype;
    }

    public void setDealmantype(String dealmantype) {
        this.dealmantype = dealmantype == null ? null : dealmantype.trim();
    }
}