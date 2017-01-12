package com.MrCBBS.mapper;

import com.MrCBBS.entities.Applicate;

public interface ApplicateMapper  extends MyBatisSuperMapper {
    int deleteByPrimaryKey(Integer apid);

    int insert(Applicate record);

    int insertSelective(Applicate record);

    Applicate selectByPrimaryKey(Integer apid);

    int updateByPrimaryKeySelective(Applicate record);

    int updateByPrimaryKey(Applicate record);
}