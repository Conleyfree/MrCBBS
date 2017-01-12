package com.MrCBBS.mapper;

import com.MrCBBS.entities.Admin;
import com.MrCBBS.entities.AdminKey;

public interface AdminMapper  extends MyBatisSuperMapper {
    int deleteByPrimaryKey(AdminKey key);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(AdminKey key);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}