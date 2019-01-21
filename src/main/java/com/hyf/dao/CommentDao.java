package com.hyf.dao;

import com.hyf.entity.Comment;
import com.hyf.entity.Link;
import com.hyf.entity.News;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public interface CommentDao {

    List<Comment> selectCommentList(News news);

    void saveComment(Comment comment);

    List<Comment> selectAll(Comment comment);

    int deleteCommentById(Comment comment);

    Comment selectByCurrent(Comment comment);
}
