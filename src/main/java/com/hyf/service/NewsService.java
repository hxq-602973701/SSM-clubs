package com.hyf.service;

import com.hyf.entity.News;
import com.hyf.entity.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public interface NewsService {
    /**
     * 根据参数查询出不同条件的列表
     * @param news
     * @return
     */
    List<News> selectByCommon(News news);

    /**
     * 头条新闻
     * @param news
     * @return
     */
    List<News> selectByHead(News news);

    /**
     * 最近新闻
     * @param news
     * @return
     */
    List<News> selectByCurrent(News news);

    /**
     * 热点新闻
     * @param news
     * @return
     */
    List<News> selectByHot(News news);

    /**
     * 根据信息类别Id查找新闻数据
     * @param newsTypeId
     * @return
     */
    List<News> selectByNewsTypeId(int newsTypeId);

    /**
     * 按点击次数排序的新闻数据
     * @param news
     * @return
     */
    List<News> selectByClick(News news);

    /**
     * 分页查找数据
     * @param typeId
     * @param start
     * @param pageSize
     * @return
     */
    List<News> selectNewslistByPage(int typeId,int start,int pageSize);

    /**
     * 根据类别Id查找总数
     * @param typeId
     * @return
     */
    int selectTotal(int typeId);


    List<News> selectByTypeId(News news);

    /**
     * 新闻Id查询新闻
     * @param news
     * @return
     */
    News selectByNewsId(News news);

    /**
     * 上一篇‘下一篇
     * @param news
     * @return
     */
    List<News> getUpAndDownPageId(News news);

    List<News> getDownPageId(News news);

    /**
     * 更新阅读次数
     * @param news
     */
    void updateByClick(News news);
}
