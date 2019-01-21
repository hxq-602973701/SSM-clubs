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

    //?????????static?????Spring??????????????????????
    public static List<NewsType> newsTypeList = new ArrayList<>();
    public static List<News> newestNewsList = new ArrayList<>();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getNewsTypeList(final Model model, News news) {
        //??????????
        newsTypeList = newsTypeService.selectByNewsType(news);
        model.addAttribute("newsTypeList", newsTypeList);
        //?????????????????
        List allIndexNewsList = new ArrayList();
        if (newsTypeList != null && newsTypeList.size() != 0) {
            for (NewsType newsType : newsTypeList) {
                List<News> newsList = newsService.selectByNewsTypeId(newsType.getNewsTypeId());
                allIndexNewsList.add(newsList);
            }
           /* newsTypeList.parallelStream().forEach(newsType -> {
                List<News> newsList = newsService.selectByNewsTypeId(newsType.getNewsTypeId());
                allIndexNewsList.add(newsList);
            });*/
        }
        model.addAttribute("allIndexNewsList", allIndexNewsList);
        //?????????
        List<News> imageNewsList = newsService.selectByCommon(news);
        model.addAttribute("imageNewsList", imageNewsList);
        //??????????
        List<News> headNewsList = newsService.selectByHead(news);
        if (headNewsList.size() != 0) {
            News headNews = headNewsList.get(0);
            headNews.setContent(StringUtil.Html2Text(headNews.getContent()));
            model.addAttribute("headNews", headNews);
        }
        //?????????
        newestNewsList = newsService.selectByCurrent(news);
        model.addAttribute("newestNewsList", newestNewsList);
        //???????
        List<News> hotSpotNewsList = newsService.selectByHot(news);
        model.addAttribute("hotSpotNewsList", hotSpotNewsList);
        //????????
        List<Link> linkList = linkService.selectAll();
        model.addAttribute("linkList", linkList);
        return "/index";
    }

    @RequestMapping(value = "/newsType", method = RequestMethod.GET)
    public String preSaveNewsType(final Model model, NewsType newsType) {
        if (newsType.getNewsTypeId() == null) {
            model.addAttribute("navCode", NavUtil.genNewsManageNavigation("新闻类别管理", "新闻类别添加 "));
        } else {
            newsType = newsTypeService.getNesTypeById(newsType);
            model.addAttribute("newsType", newsType);
            model.addAttribute("navCode", NavUtil.genNewsManageNavigation("新闻类别管理", "新闻类别维护"));
        }
        model.addAttribute("mainPage", "/background/newsType/newsTypeSave.jsp");
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/newsTypeSave", method = RequestMethod.POST)
    public String SaveLink(final Model model, NewsType newsType) {
        if (newsType.getNewsTypeId() == null) {
            newsTypeService.save(newsType);
        } else {
            newsTypeService.updateByNewsTypeId(newsType);
        }
        return "redirect:newsTypeList.do";
    }

    @RequestMapping(value = "/newsTypeList", method = RequestMethod.GET)
    public String LnkList(final Model model) {
        List<NewsType> newsTypeBackList = newsTypeService.selectAll();
        model.addAttribute("navCode", NavUtil.genNewsManageNavigation("新闻类别管理", "新闻类别维护"));
        model.addAttribute("newsTypeBackList", newsTypeBackList);
        model.addAttribute("mainPage", "/background/newsType/newsTypeList.jsp");
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/newsTypeDelete", method = RequestMethod.POST)
    public void newsTypeDelete(final Model model, NewsType newsType, HttpServletResponse response) throws Exception {
        int delNums = newsTypeService.deleteNewsTypeById(newsType);
        boolean flag;
        if (delNums > 0) {
            flag = true;
        } else {
            flag = false;
        }
        ResponseUtil.write(flag, response);
    }


}
