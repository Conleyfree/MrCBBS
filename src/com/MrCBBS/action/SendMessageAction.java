package com.MrCBBS.action;

import com.MrCBBS.Server.AdminService;

/**
 * Created by HandsomeMrChen on 2017/1/26.
 */
public class SendMessageAction extends CommonAction {
    private String adminName;
    private String uid;
    private String pid;
    private String content;

    private String message;
    private String statusCode;

    private AdminService adminService;
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    /* 提供给ajax */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String execute() throws Exception {
        if(adminName.equals("")){
            statusCode = "401";
            message = "未授权访问！";
        }else {
            adminService.sendMessage(adminName, content, uid, pid);
            statusCode = "200";
            message = "信息已发送！";
        }
        return SUCCESS;
    }
}
