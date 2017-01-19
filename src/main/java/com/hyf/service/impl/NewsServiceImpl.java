package com.hyf.service.impl;

import com.hyf.dao.NewsDao;
import com.hyf.entity.News;
import com.hyf.entity.PageBean;
import com.hyf.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsDao newsDao;

    @Override
    public List<News> selectByCommon(News news) {
        return newsDao.selectByCommon(news);
    }

    @Override
    public List<News> selectByHead(News news) {
        return newsDao.selectByHead(news);
    }

    @Override
    public List<News> selectByCurrent(News news) {
        return newsDao.selectByCurrent();
    }

    @Override
    public List<News> selectByHot(News news) {
        return newsDao.selectByHot(news);
    }

    @Override
    public List<News> selectByNewsTypeId(int newsTypeId) {
        return newsDao.selectByNewsTypeId(newsTypeId);
    }

    @Override
    public List<News> selectByClick(News news) {
        return newsDao.selectByClick(news);
    }

    @Override
    public List<News> selectNewslistByPage(int typeId, int start,int pageSize) {
        return newsDao.selectNewslistByPage(typeId,start,pageSize);
    }

    @Override
    public int selectTotal(int typeId) {
        return newsDao.selectTotal(typeId);
    }

    @Override
    public List<News> selectByTypeId(News news) {
        return newsDao.selectByTypeId(news);
    }

    @Override
    public News selectByNewsId(News news) {
        return newsDao.selectByNewsId(news);
    }

    @Override
    public List<News> getUpAndDownPageId(News news) {
        return newsDao.getUpAndDownPageId(news);
    }

    @Override
    public List<News> getDownPageId(News news) {
        return newsDao.getDownPageId(news);
    }

    @Override
    public void updateByClick(News news) {
        newsDao.updateByClick(news);
    }
}
