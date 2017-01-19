package com.hyf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyf.entity.Comment;
import com.hyf.entity.Link;
import com.hyf.entity.News;
import com.hyf.entity.NewsType;
import com.hyf.service.CommentService;
import com.hyf.service.LinkService;
import com.hyf.service.NewsService;
import com.hyf.service.NewsTypeService;
import com.hyf.util.NavUtil;
import com.hyf.util.PageUtil;
import com.hyf.util.PropertiesUtil;
import com.hyf.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class NewsController {

    @Resource
    private NewsTypeService newsTypeService;

    @Resource
    private NewsService newsService;

    @Resource
    private LinkService linkService;

    @Resource
    private CommentService commentService;

    //将数据放在static中，在Spring容器启动时加载，只加载一次
    public static  List<NewsType> newsTypeList = new ArrayList<>();
    public static  List<News> newestNewsList = new ArrayList<>();
    public static  List<News> hotNewsList = new ArrayList<>();
    public static  List<Link> linkList = new ArrayList<>();

    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public String getNewsList(final Model model, News news, String page, Comment comment, HttpServletRequest request){
        //新闻类别显示
        newsTypeList = newsTypeService.selectByNewsType(news);
        model.addAttribute("newsTypeList",newsTypeList);
        //最近的新闻
        newestNewsList = newsService.selectByCurrent(news);
        model.addAttribute("newestNewsList",newestNewsList);
        //热点新闻
        hotNewsList = newsService.selectByClick(news);
        model.addAttribute("hotNewsList",hotNewsList);
        //友情链接
        linkList = linkService.selectAll();
        model.addAttribute("linkList",linkList);
        //分页显示新闻
        if(StringUtil.isEmpty(page)){
            page = "1";
        }
        if(news.getTypeId()!=-1){
           news.setTypeId(news.getTypeId());
        }
        //按新闻类别准备数据
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
        List<News> newestNewsListWithType =  newsService.selectByTypeId(news);
        PageInfo<News> pageInfo = new PageInfo<News>(newestNewsListWithType);
        model.addAttribute("newestNewsListWithType",newestNewsListWithType);
        //设置公共页
        if(news.getTypeId()==0){
            model.addAttribute("mainPage","news/newsShow.jsp");
        }else{
            model.addAttribute("mainPage","news/newsList.jsp");
        }
        //按新闻Id准备数据并设置当前位置
        if(news.getNewsId()!=0){
            newsService.updateByClick(news);
            news =  newsService.selectByNewsId(news);
            List<News> upPage = newsService.getUpAndDownPageId(news);
            List<News> downPage = newsService.getDownPageId(news);
            if(downPage.size()==0){
                downPage.add(new News(-1,""));
            }if(upPage.size()==0){
                upPage.add(new News(-1,""));
            }
            //准备评论数据
            List<Comment> commentList = commentService.selectCommentList(news);
            model.addAttribute("commentList",commentList);

            model.addAttribute("pageCode",PageUtil.genUpAndDownPageCode(upPage,downPage));
            model.addAttribute("news",news);
            model.addAttribute("navCode",NavUtil.genNewsNavigation(news.getTypeName(), news.getTypeId()+"",news.getTitle()));
        }else{
            NewsType newsType = newsTypeService.selectByNewsTypeId(news);
            model.addAttribute("navCode", NavUtil.genNewsListNavigation(newsType.getTypeName(),news.getTypeId()));
            long total = pageInfo.getTotal();
            model.addAttribute("pageCode", PageUtil.getUpAndDownPagation(total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), news.getTypeId()));
        }
        return  "/foreground/newsTemp";
    }

}
