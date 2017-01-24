package com.MrCBBS.action;

import java.net.InetAddress;
import java.util.Random;
import com.MrCBBS.Server.RegistService;
import com.MrCBBS.entities.User;

@SuppressWarnings("serial")
public class RegistAction extends CommonAction{
	String passWD;		//密码
	String rePassWD;	//确认密码
	String nickName;	//昵称
	String email;		//邮箱

	/* setter方法获取request参数 */
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassWD(String passWD) {
		this.passWD = passWD;
	}

	public void setRePassWD(String rePassWD) {
		this.rePassWD = rePassWD;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	private RegistService registService;

	public void setRegistService(RegistService registService)
	{
		this.registService = registService;
	}
    
	public String execute() throws Exception{
		// TODO Auto-generated method stub		
		String errMes = "";
		if(!passWD.equals(rePassWD)){
			//两次密码输入不同
			errMes += "两次密码输入不同；";
		}
		if(!email.endsWith(".com") || !email.contains("@")){
			//邮箱格式不正确
			errMes += "邮箱格式不正确,正确的格式为“123@123.com”；";
		}
		if(!errMes.equals("")){	//错误信息不等于空
			request.setAttribute("EM", errMes);
			System.out.println(errMes);
			return ERROR;
		}
		
		if(registService.isExistByUNickName(nickName)){	//昵称不能相同
			String EM = "不好意思，该昵称已经有人使用了，换一个更帅气的吧！";
			request.setAttribute("EM", EM);
			return ERROR;
		}
		
		//信息判断结束，调用服务组件
		String UID = "";
		UID += InetAddress.getLocalHost().getHostAddress();
		UID = UID.replace(".", "_");
		int index = 20 - UID.length();
		Random random = new Random(System.currentTimeMillis());
		do{
			double r = random.nextDouble();
			for(int i = 0; i < index; i++){
				r *= 10;
			}
			UID += Double.toString(r);
			UID = UID.replace(".", "B").substring(0, 20);	
		}while(registService.isExistByUID(UID));
		
		System.out.println(UID);
		User user = new User(UID, nickName, passWD, email);
		user.setuTag(0);
		if(registService.registNewUser(user)){
			//成功注册用户
			String SM = "注册成功！赶快去登录吧！";
			request.setAttribute("SM", SM);
			return SUCCESS;
		}
		
		request.setAttribute("EM", "系统故障，请稍后注册~");
		return ERROR;
	}

}
