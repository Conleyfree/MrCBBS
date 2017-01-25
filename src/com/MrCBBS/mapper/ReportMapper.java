package com.MrCBBS.mapper;

import com.MrCBBS.entities.Report;

public interface ReportMapper extends MyBatisSuperMapper {
    public int deleteByPrimaryKey(Integer rid);

    public int insert(Report record);

    public int insertSelective(Report record);

    public Report selectByPrimaryKey(Integer rid);

    public int updateByPrimaryKeySelective(Report record);

    public int updateByPrimaryKey(Report record);
}