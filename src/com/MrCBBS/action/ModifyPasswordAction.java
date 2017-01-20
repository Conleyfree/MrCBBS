package com.MrCBBS.action;

import com.MrCBBS.Server.UserService;
import com.MrCBBS.entities.User;

import javax.servlet.http.HttpSession;

/**
 * Created by HandsomeMrChen on 2017/1/20.
 */
public class ModifyPasswordAction extends CommonAction {
    private String newPassword;
    private String rePassword;
    private String oldPassword;
    private String message;
    private String statusCode;

    /* 提供setter与getter方法供 ajax调用 */
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
    public void setRePassword(String rePassword) { this.rePassword = rePassword; }
    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }

    public String getMessage() { return message; }
    public String getStatusCode() { return statusCode; }

    private UserService userService;
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    /*  修改密码   */
    public String execute() throws Exception {
        HttpSession httpSession = request.getSession();
        User user = (User)httpSession.getAttribute("User");
        if(newPassword!=null && !newPassword.equals("") && newPassword.equals(rePassword)){
            statusCode = userService.modifyUserPassWD(user, oldPassword, newPassword);
            if(statusCode.equals("200"))    message="密码修改成功！";
            else                            message="原密码输入错误，请重新输入！";       //statusCode值为201
        } else{
            if(newPassword == null) {
                statusCode = "300";
                message="存在非法操作，当前不允许你修改密码！";
            } else if(newPassword.equals("")) {
                statusCode = "301";
                message="修改新密码不能为空！";
            } else {
                statusCode = "302";
                message="两次输入的密码不同！";
            }
        }
        System.out.println("message:" + message + "  ;statusCode:" + statusCode);
        return SUCCESS;
    }

}
