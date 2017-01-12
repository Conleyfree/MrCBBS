package com.MrCBBS.mapper;

import com.MrCBBS.entities.Appraise4com;

public interface Appraise4comMapper  extends MyBatisSuperMapper {
    int insert(Appraise4com record);

    int insertSelective(Appraise4com record);
}