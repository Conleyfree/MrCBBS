package com.MrCBBS.mapper;

import com.MrCBBS.entities.Appraise4post;

public interface Appraise4postMapper extends MyBatisSuperMapper  {
    int insert(Appraise4post record);

    int insertSelective(Appraise4post record);
    Appraise4post selectByPostIdAndUserId(Appraise4post record);
    void updateByPostIdAndUserId(Appraise4post record);
    Integer countPostValue(Appraise4post record);
    Integer countUserValue(Appraise4post record);
}