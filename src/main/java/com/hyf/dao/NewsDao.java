package com.hyf.dao;

import com.hyf.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public interface NewsDao {
    List<News> selectByCommon(News news);

    List<News> selectByHead(News news);

    List<News> selectByCurrent();

    List<News> selectByHot(News news);

    List<News> selectByNewsTypeId(int newsTypeId);

    List<News> selectByClick(News news);

    List<News> selectNewslistByPage(@Param("typeId")int typeId, @Param("start")int start, @Param("pageSize")int pageSize);

    int selectTotal(int typeId);

    List<News> selectByTypeId(News news);

    News selectByNewsId(News news);

    List<News> getUpAndDownPageId(News news);

    List<News> getDownPageId(News news);

    void updateByClick(News news);

    void newsAdd(News news);

    List<News> selectAll(News news);

    void update(News news);

    int deleteNewsById(News news);
}
