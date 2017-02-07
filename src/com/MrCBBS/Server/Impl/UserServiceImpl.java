package com.MrCBBS.Server.Impl;

import com.MrCBBS.DAO.MessageDAO;
import com.MrCBBS.DAO.UserDAO;
import com.MrCBBS.Server.UserService;
import com.MrCBBS.entities.Message;
import com.MrCBBS.entities.User;

import java.util.List;

/**
 * Created by HandsomeMrChen on 2017/1/2.
 */
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;
    private MessageDAO messageDAO;
    public void setUserDAO(UserDAO userDAO){ this.userDAO = userDAO; }
    public void setMessageDAO(MessageDAO messageDAO) { this.messageDAO = messageDAO; }

    @Override
    public User selectOneByUAccount(String uAccount) {
        User user = userDAO.selectOneByUAccount(uAccount);
        return user;
    }

    @Override
    public String modifyUserPassWD(User user, String oldPassword, String newPassword) {
        String password = userDAO.selectOneByUID(user.getUid()).getuPassWD();
        if(password.equals(oldPassword)){       //输入密码与原密码相同
            user.setuPassWD(newPassword);
            userDAO.updateUserPassWD(user);
            return "200";   //成功
        }else {
            return "201";   //密码输入有误
        }
    }

    @Override
    public List<Message> getUnreadedMsg(String uAccount) {
        return messageDAO.getUnreadedMsg(uAccount);
    }

    @Override
    public List<Message> getReadedMsg(String uAccount) {
        return messageDAO.getReadedMsg(uAccount);
    }
}
