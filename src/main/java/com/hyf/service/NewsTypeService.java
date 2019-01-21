package com.hyf.service;

import com.hyf.entity.News;
import com.hyf.entity.NewsType;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public interface NewsTypeService {

    /**
     * 获取新闻类别列表
     *
     * @param news
     * @return
     */
    List<NewsType> selectByNewsType(News news);

    /**
     * 根据typeId查找
     *
     * @param news
     * @return
     */
    NewsType selectByNewsTypeId(News news);

    NewsType getNesTypeById(NewsType newsType);

    void save(NewsType newsType);

    void updateByNewsTypeId(NewsType newsType);

    List<NewsType> selectAll();

    int deleteNewsTypeById(NewsType newsType);
}
