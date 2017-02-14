package com.hyf.controller;

import com.hyf.entity.Link;
import com.hyf.entity.News;
import com.hyf.entity.NewsType;
import com.hyf.service.LinkService;
import com.hyf.service.NewsService;
import com.hyf.service.NewsTypeService;
import com.hyf.util.NavUtil;
import com.hyf.util.ResponseUtil;
import com.hyf.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class NewsTypeController {

    @Resource
    private NewsTypeService newsTypeService;

    @Resource
    private NewsService newsService;

    @Resource
    private LinkService linkService;

    //将数据放在static中，在Spring容器启动时加载，只加载一次
    public static  List<NewsType> newsTypeList = new ArrayList<>();
    public static  List<News> newestNewsList = new ArrayList<>();

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getNewsTypeList(final Model model, News news){
        //新闻类别显示
        newsTypeList = newsTypeService.selectByNewsType(news);
        model.addAttribute("newsTypeList",newsTypeList);
        //每个新闻类别下的新闻
        List allIndexNewsList = new ArrayList();
        if(newsTypeList!=null && newsTypeList.size()!=0){
            newsTypeList.parallelStream().forEach(newsType -> {
                List<News> newsList = newsService.selectByNewsTypeId(newsType.getNewsTypeId());
                allIndexNewsList.add(newsList);
            });
        }
        model.addAttribute("allIndexNewsList",allIndexNewsList);
        //左侧轮播显示
        List<News>  imageNewsList = newsService.selectByCommon(news);
        model.addAttribute("imageNewsList",imageNewsList);
        //头条新闻显示
        List<News>  headNewsList = newsService.selectByHead(news);
        News headNews = headNewsList.get(0);
        headNews.setContent(StringUtil.Html2Text(headNews.getContent()));
        model.addAttribute("headNews",headNews);
        //最近的新闻
        newestNewsList = newsService.selectByCurrent(news);
        model.addAttribute("newestNewsList",newestNewsList);
        //热点新闻
        List<News> hotSpotNewsList = newsService.selectByHot(news);
        model.addAttribute("hotSpotNewsList",hotSpotNewsList);
        //友情链接
        List<Link> linkList = linkService.selectAll();
        model.addAttribute("linkList",linkList);
        return  "/index";
    }

    @RequestMapping(value = "/newsType",method = RequestMethod.GET)
    public String preSaveNewsType(final Model model,NewsType newsType) {
        if(newsType.getNewsTypeId()==null){
            model.addAttribute("navCode", NavUtil.genNewsManageNavigation("新闻类别管理", "新闻类别管理"));
        }else{
            newsType = newsTypeService.getNesTypeById(newsType);
            model.addAttribute("newsType",newsType);
            model.addAttribute("navCode", NavUtil.genNewsManageNavigation("新闻类别管理", "新闻类别修改"));
        }
        model.addAttribute("mainPage","/background/newsType/newsTypeSave.jsp");
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/newsTypeSave",method = RequestMethod.POST)
    public String SaveLink(final Model model,NewsType newsType) {
        if (newsType.getNewsTypeId() == null) {
            newsTypeService.save(newsType);
        }else{
            newsTypeService.updateByNewsTypeId(newsType);
        }
        return"redirect:newsTypeList.do";
    }

    @RequestMapping(value = "/newsTypeList",method = RequestMethod.GET)
    public String LnkList(final Model model) {
        List<NewsType> newsTypeBackList = newsTypeService.selectAll();
        model.addAttribute("navCode", NavUtil.genNewsManageNavigation("车友类别管理", "车友类别维护"));
        model.addAttribute("newsTypeBackList",newsTypeBackList);
        model.addAttribute("mainPage", "/background/newsType/newsTypeList.jsp");
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/newsTypeDelete",method = RequestMethod.POST)
    public  void newsTypeDelete(final Model model,NewsType newsType,HttpServletResponse response)throws Exception {
        int delNums = newsTypeService.deleteNewsTypeById(newsType);
        boolean flag;
        if(delNums>0){
            flag = true;
        }else {
            flag = false;
        }
        ResponseUtil.write(flag,response);
    }


}
