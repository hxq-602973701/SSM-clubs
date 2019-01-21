package com.hyf.controller;

import com.hyf.entity.News;
import com.hyf.entity.NewsType;
import com.hyf.service.NewsTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class IndexController {

    public static List<NewsType> newsTypeList = new ArrayList<>();

    @Resource
    private NewsTypeService newsTypeService;

    @RequestMapping(value = "/goBack", method = RequestMethod.GET)
    public String goBack(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("currentFUser") != null) {
            return "/background/mainTemp";
        } else {
            return "/background/login";
        }
    }

    @RequestMapping(value = "/sendMsg", method = RequestMethod.GET)
    public String sendMsg(final Model model, News news) {
        newsTypeList = newsTypeService.selectByNewsType(news);
        model.addAttribute("newsTypeList", newsTypeList);
        return "/background/news/newsSave";
    }

}
