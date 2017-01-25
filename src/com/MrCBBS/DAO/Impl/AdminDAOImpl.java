package com.MrCBBS.DAO.Impl;

import com.MrCBBS.DAO.AdminDAO;
import com.MrCBBS.entities.Admin;
import com.MrCBBS.mapper.AdminMapper;

/**
 * Created by HandsomeMrChen on 2017/1/25.
 */
public class AdminDAOImpl implements AdminDAO {

    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin selectAdminByAName(String AName) {
        return adminMapper.selectAdminByAName(AName);
    }
}
