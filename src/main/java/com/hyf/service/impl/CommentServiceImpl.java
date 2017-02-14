package com.hyf.service.impl;

import com.hyf.dao.CommentDao;
import com.hyf.entity.Comment;
import com.hyf.entity.Link;
import com.hyf.entity.News;
import com.hyf.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public List<Comment> selectCommentList(News news) {
        return commentDao.selectCommentList(news);
    }

    @Override
    public void saveComment(Comment comment) {
        commentDao.saveComment(comment);
    }

    @Override
    public List<Comment> selectAll(Comment comment) {
        return commentDao.selectAll(comment);
    }

    @Override
    public int deleteCommentById(Comment comment) {
        return commentDao.deleteCommentById(comment);
    }
}
