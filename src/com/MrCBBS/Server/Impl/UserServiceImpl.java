package com.MrCBBS.Server.Impl;

import com.MrCBBS.DAO.UserDAO;
import com.MrCBBS.Server.UserService;
import com.MrCBBS.entities.User;

/**
 * Created by HandsomeMrChen on 2017/1/2.
 */
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO){ this.userDAO = userDAO; }

    @Override
    public User selectOneByUAccount(String uAccount) {
        User user = userDAO.selectOneByUAccount(uAccount);
        return user;
    }
}