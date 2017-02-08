package com.MrCBBS.Server;

import com.MrCBBS.entities.Message;
import com.MrCBBS.entities.User;

import java.util.List;

/**
 * Created by HandsomeMrChen on 2017/1/2.
 */
public interface UserService {
    User selectOneByUAccount(String uAccount);

    /* 修改密码 */
    String modifyUserPassWD(User user, String oldPassword, String newPassword);

    /* 获取未读消息 */
    List<Message> getUnreadedMsg(String uAccount);

    /* 获取已读消息 */
    List<Message> getReadedMsg(String uAccount);

    /* 标记消息已读 */
    Boolean markMsg(String mid);
}
