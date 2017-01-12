package com.MrCBBS.Server;

import com.MrCBBS.entities.User;

/**
 * Created by HandsomeMrChen on 2017/1/2.
 */
public interface UserService {
    User selectOneByUAccount(String uAccount);
}
