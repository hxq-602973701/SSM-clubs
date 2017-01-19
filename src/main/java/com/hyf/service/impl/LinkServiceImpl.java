package com.hyf.service.impl;

import com.hyf.dao.LinkDao;
import com.hyf.entity.Link;
import com.hyf.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkDao linkDao;

    @Override
    public List<Link> selectAll() {
        return linkDao.selectAll();
    }

    @Override
    public void save(Link link) {
        linkDao.save(link);
    }

    @Override
    public Link selectLinkById(Link link) {
        return linkDao.selectLinkById(link);
    }

    @Override
    public void updateByLinkId(Link link) {
        linkDao.updateByLinkId(link);
    }

    @Override
    public int deleteLinkById(Link link) {
        return linkDao.deleteLinkById(link);
    }
}
