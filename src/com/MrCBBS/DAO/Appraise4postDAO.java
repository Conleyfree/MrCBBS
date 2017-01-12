package com.MrCBBS.DAO;

import com.MrCBBS.entities.Appraise4post;
import com.MrCBBS.mapper.Appraise4postMapper;

/**
 * Created by anzer on 2016/12/18.
 */
public interface Appraise4postDAO {
    public void upsert(Appraise4post appraise4post);
    public int like(Appraise4post appraise4post);
    public int hate(Appraise4post appraise4post);
    public int countPostValue(Appraise4post appraise4post);
    public int countUserValue(Appraise4post appraise4post);
}
