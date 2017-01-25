package com.MrCBBS.DAO;

import com.MrCBBS.entities.Admin;

/**
 * Created by HandsomeMrChen on 2017/1/25.
 */
public interface AdminDAO {

    /* 根据管理员名字获取一个管理员对象 */
    Admin selectAdminByAName(String AName);
}
