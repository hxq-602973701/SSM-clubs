package com.hyf.dao;

import com.hyf.entity.Leave;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public interface LeaveDao {
    void save(Leave leave);

    List<Leave> select();
}
