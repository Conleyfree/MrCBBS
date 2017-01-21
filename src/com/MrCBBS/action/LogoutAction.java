package com.MrCBBS.action;

import javax.servlet.http.HttpSession;

/**
 * Created by HandsomeMrChen on 2017/1/21.
 */
public class LogoutAction extends CommonAction{

    /*	2017.1.21
		登出
	 */
    public String execute() throws Exception{
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("User");
        httpSession.invalidate();	//清空session内的值
        return SUCCESS;
    }
}
