package com.MrCBBS.DAO.Impl;

import com.MrCBBS.DAO.Appraise4postDAO;
import com.MrCBBS.entities.Appraise4post;
import com.MrCBBS.mapper.Appraise4postMapper;

/**
 * Created by anzer on 2016/12/18.
 */
public class Appraise4postDAOImpl implements Appraise4postDAO{
    private Appraise4postMapper appraise4postMapper;

    @Override
    public int countPostValue(Appraise4post appraise4post) {
        return appraise4postMapper.countPostValue(appraise4post);
    }

    @Override
    public int countUserValue(Appraise4post appraise4post) {
        return appraise4postMapper.countUserValue(appraise4post);
    }

    public Appraise4postMapper getAppraise4postMapper() {
        return appraise4postMapper;
    }

    public void setAppraise4postMapper(Appraise4postMapper appraise4postMapper) {
        this.appraise4postMapper = appraise4postMapper;
    }

    public void upsert(Appraise4post appraise4post){
        Appraise4post selectedAppraise4post=appraise4postMapper.selectByPostIdAndUserId(appraise4post);
        if(selectedAppraise4post==null){
            appraise4postMapper.insert(appraise4post);
        }else{
            appraise4postMapper.updateByPostIdAndUserId(appraise4post);
        }


    }
    public int like(Appraise4post appraise4post){
        Appraise4post selectedAppraise4post=appraise4postMapper.selectByPostIdAndUserId(appraise4post);
        if(selectedAppraise4post==null){
            appraise4post.setValue((short)1);
            appraise4postMapper.insert(appraise4post);
            return 0;
        }else{

            if((int)(selectedAppraise4post.getValue())==1){
                appraise4post.setValue((short)0);
                appraise4postMapper.updateByPostIdAndUserId(appraise4post);
                return 1;
            }else if((int)(selectedAppraise4post.getValue())==0){
                appraise4post.setValue((short)1);
                appraise4postMapper.updateByPostIdAndUserId(appraise4post);
                return 0;
            }else{
                appraise4post.setValue((short)1);
                appraise4postMapper.updateByPostIdAndUserId(appraise4post);
                return -1;
            }
        }
    }
    public int hate(Appraise4post appraise4post){
        Appraise4post selectedAppraise4post=appraise4postMapper.selectByPostIdAndUserId(appraise4post);
        if(selectedAppraise4post==null){
            appraise4post.setValue((short)-1);
            appraise4postMapper.insert(appraise4post);
            return 0;
        }else{
            if((int)(selectedAppraise4post.getValue())==-1){
                appraise4post.setValue((short)0);
                appraise4postMapper.updateByPostIdAndUserId(appraise4post);
                return -1;
            }else if((int)(selectedAppraise4post.getValue())==0){
                appraise4post.setValue((short)-1);
                appraise4postMapper.updateByPostIdAndUserId(appraise4post);
                return 0;
            }else{
                appraise4post.setValue((short)-1);
                appraise4postMapper.updateByPostIdAndUserId(appraise4post);
                return 1;
            }
        }
    }

}
