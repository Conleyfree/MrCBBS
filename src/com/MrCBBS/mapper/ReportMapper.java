package com.MrCBBS.mapper;

import com.MrCBBS.entities.Report;

public interface ReportMapper extends MyBatisSuperMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);
}