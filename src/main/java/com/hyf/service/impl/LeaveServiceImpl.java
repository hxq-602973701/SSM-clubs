package com.hyf.service.impl;

import com.hyf.dao.LeaveDao;
import com.hyf.dao.UserDao;
import com.hyf.entity.Leave;
import com.hyf.entity.User;
import com.hyf.service.LeaveService;
import com.hyf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {

    @Resource
    private LeaveDao leaveDao;

    @Override
    public Integer save(Leave leave) {
        return leaveDao.save(leave);
    }

    @Override
    public List<Leave> select(Leave leave) {

        return leaveDao.select(leave);
    }

    @Override
    public Leave selectBycurrent(Leave leave) {
        return leaveDao.selectBycurrent(leave);
    }
}
