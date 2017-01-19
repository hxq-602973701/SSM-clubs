package com.hyf.service.impl;

import com.hyf.dao.NewsTypeDao;
import com.hyf.entity.News;
import com.hyf.entity.NewsType;
import com.hyf.service.NewsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Service("newsTypeService")
public class NewsTypeServiceImpl implements NewsTypeService{

    @Resource
    private NewsTypeDao newsTypeDao;

    @Override
    public List<NewsType> selectByNewsType(News news) {
        return newsTypeDao.selectByNewsType(news);
    }

    @Override
    public NewsType selectByNewsTypeId(News news) {
        return newsTypeDao.selectByNewsTypeId(news);
    }
}
