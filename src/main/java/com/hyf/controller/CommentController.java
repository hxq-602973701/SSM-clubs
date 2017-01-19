package com.hyf.controller;

import com.hyf.entity.Comment;
import com.hyf.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/comment",method = RequestMethod.GET)
    public String getNewsList(final Model model,Comment comment, HttpServletRequest request) {

        //发布新闻
        comment.setUserIP(request.getRemoteAddr());
        comment.setCommentDate(new Date());
        commentService.saveComment(comment);
        int newsId = comment.getNewsId();
        model.addAttribute("newsId",newsId);
        return "toTemp";
    }

}
