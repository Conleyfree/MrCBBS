package com.MrCBBS.mapper;

import com.MrCBBS.entities.Message;

public interface MessageMapper  extends MyBatisSuperMapper {
    public int deleteByPrimaryKey(Integer mid);

    public int insert(Message record);

    public int insertSelective(Message record);

    public Message selectByPrimaryKey(Integer mid);

    public int updateByPrimaryKeySelective(Message record);

    public int updateByPrimaryKey(Message record);
}