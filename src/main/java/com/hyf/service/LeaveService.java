package com.hyf.service;

import com.hyf.entity.Leave;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public interface LeaveService {

    /**
     * 插入留言
     *
     * @param leave
     */
    Integer save(Leave leave);

    List<Leave> select(Leave leave);

   Leave selectBycurrent(Leave leave);
}
