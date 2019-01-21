package com.hyf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyf.entity.Comment;
import com.hyf.entity.Link;
import com.hyf.entity.NewsType;
import com.hyf.service.CommentService;
import com.hyf.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public String getNewsList(final Model model, Comment comment, HttpServletRequest request) {

        //发布新闻
        comment.setUserIP(request.getRemoteAddr());
        comment.setCommentDate(new Date());
        commentService.saveComment(comment);
        int newsId = comment.getNewsId();
        model.addAttribute("newsId", newsId);
        return "toTemp";
    }

    @RequestMapping(value = "/commentList", method = RequestMethod.GET)
    public String commentList(final Model model, String page, Comment comment, HttpServletRequest request) {
        if (StringUtil.isEmpty(page)) {
            page = "1";
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("commentPageSize")));
        List<Comment> commentBackList = commentService.selectAll(comment);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(commentBackList);
        int total = (int) pageInfo.getTotal();
        String pageCode = PageUtil.getPagation(request.getContextPath() + "/commentList.do?action=backList", total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("commentPageSize")));
        model.addAttribute("pageCode", pageCode);
        model.addAttribute("navCode", NavUtil.genNewsManageNavigation("评论管理", "评论维护"));
        model.addAttribute("commentBackList", commentBackList);
        model.addAttribute("mainPage", "/background/comment/commentList.jsp");
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/commentListA", method = RequestMethod.GET)
    public String commentListA(final Model model, Comment comment) {
        model.addAttribute("aaa", comment);
        return "forward:commentList.do";
    }

    @RequestMapping(value = "/commentDelete", method = RequestMethod.POST)
    public void newsTypeDelete(final Model model, Comment comment, HttpServletResponse response) throws Exception {
        int delNums = commentService.deleteCommentById(comment);
        boolean flag;
        if (delNums > 0) {
            flag = true;
        } else {
            flag = false;
        }
        ResponseUtil.write(flag, response);
    }

}
