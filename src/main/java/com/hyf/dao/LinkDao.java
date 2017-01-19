package com.hyf.dao;

import com.hyf.entity.Link;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public interface LinkDao {

    List<Link> selectAll();

    void save(Link link);

    Link selectLinkById(Link link);

    void updateByLinkId(Link link);

    int deleteLinkById(Link link);
}
