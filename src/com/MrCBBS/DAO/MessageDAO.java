package com.MrCBBS.DAO;

import com.MrCBBS.entities.Message;

/**
 * Created by HandsomeMrChen on 2017/2/4.
 */
public interface MessageDAO {

    //插入一条message记录
    void insert(Message record);
}
