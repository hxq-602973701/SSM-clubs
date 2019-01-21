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
import com.hyf.util.*;
import com.hyf.weather.ArrayOfString;
import com.hyf.weather.WeatherWebService;
import com.hyf.weather.WeatherWebServiceSoap;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

        //信息类别显示
        newsTypeList = newsTypeService.selectByNewsType(news);
        model.addAttribute("newsTypeList",newsTypeList);
        //车友信息最新动态
        newestNewsList = newsService.selectByCurrent(news);
        model.addAttribute("newestNewsList",newestNewsList);
        //热们信息
        hotNewsList = newsService.selectByClick(news);
        model.addAttribute("hotNewsList",hotNewsList);
        //友情链接
        linkList = linkService.selectAll();
        model.addAttribute("linkList",linkList);
        //分页显示信息
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
        //按信息Id准备数据并设置当前位置
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

    @RequestMapping(value = "/newsPre",method = RequestMethod.GET)
    public String preSaveNews(final Model model,News news) {
        newsTypeList = newsTypeService.selectByNewsType(news);
        model.addAttribute("newsTypeList",newsTypeList);
        if(news.getNewsId()==0){
            model.addAttribute("navCode", NavUtil.genNewsManageNavigation("信息管理", "信息添加"));
            model.addAttribute("assign", "qiantai");
        }else{
            news= newsService.selectByNewsId(news);
            model.addAttribute("news",news);
            model.addAttribute("navCode", NavUtil.genNewsManageNavigation("信息管理", "信息修改"));
        }
        model.addAttribute("mainPage","/background/news/newsSave.jsp");
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/newsSave",method = RequestMethod.POST)
    public String SaveNews(final Model model,News news,HttpServletRequest request,int type) throws ServletException, IOException {
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        List<FileItem> items=null;
        try {
            items=upload.parseRequest(request);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Iterator itr=items.iterator();
        while(itr.hasNext()){
            FileItem item=(FileItem) itr.next();
            if(item.isFormField()){
                String fieldName=item.getFieldName();
                if("newsId".equals(fieldName)){
                    if(StringUtil.isNotEmpty(item.getString("utf-8"))){
                        news.setNewsId(Integer.parseInt(item.getString("utf-8")));
                    }
                }
                if("title".equals(fieldName)){
                    news.setTitle(item.getString("utf-8"));
                }
                if("content".equals(fieldName)){
                    news.setContent(item.getString("utf-8"));
                }
                if("author".equals(fieldName)){
                    news.setAuthor(item.getString("utf-8"));
                }
                if("typeId".equals(fieldName)){
                    news.setTypeId(Integer.parseInt(item.getString("utf-8")));
                }
                if("isHead".equals(fieldName)){
                    news.setIsHead(Integer.parseInt(item.getString("utf-8")));
                }
                if("isImage".equals(fieldName)){
                    news.setIsImage(Integer.parseInt(item.getString("utf-8")));
                }
                if("isHot".equals(fieldName)){
                    news.setIsHot(Integer.parseInt(item.getString("utf-8")));
                }
            }else if(!"".equals(item.getName())){
                try {
                    String imageName= DateUtil.getCurrentDateStr();
                    news.setImageName(imageName+"."+item.getName().split("\\.")[1]);
                    String filePath=PropertiesUtil.getValue("imagePath")+imageName+"."+item.getName().split("\\.")[1];
                    item.write(new File(filePath));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        if(news.getNewsId()!=0){
            newsService.update(news);
        }else{
            newsService.newsAdd(news);
        }
        if(type!=1){
           return "addInfoSuccess";
        }else{
            return"redirect:newsList.do";
        }

    }

    @RequestMapping(value = "/newsList",method = RequestMethod.GET)
    public String newsList(final Model model,String page,News news,HttpServletRequest request) {
        if(StringUtil.isEmpty(page)){
            page = "1";
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("commentPageSize")));
        List<News> newsBackList = newsService.selectAll(news);
        PageInfo<News> pageInfo = new PageInfo<News>(newsBackList);
        int total = (int)pageInfo.getTotal();
        String pageCode=PageUtil.getPagation(request.getContextPath()+"/newsList.do?action=backList", total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("commentPageSize")),news);
        model.addAttribute("pageCode",pageCode);
        model.addAttribute("navCode", NavUtil.genNewsManageNavigation("信息管理", "信息维护"));
        model.addAttribute("newsBackList",newsBackList);
        model.addAttribute("mainPage", "/background/news/newsList.jsp");
        model.addAttribute("news",news);
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/newsListA",method = RequestMethod.GET)
    public String commentListA(final Model model,News news) {
        model.addAttribute("aaa",news);
        return"forward:newsList.do";
    }

    @RequestMapping(value = "/newsDelete",method = RequestMethod.POST)
    public  void NewsDelete(final Model model,News news,HttpServletResponse response)throws Exception {
        int delNums = newsService.deleteNewsById(news);
        boolean flag;
        if(delNums>0){
            flag = true;
        }else {
            flag = false;
        }
        ResponseUtil.write(flag,response);
    }

    /**
     * 审核
     * @param model
     * @param
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/info/check-info",method = RequestMethod.POST)
    public String checkInfo(Model model, News news, HttpServletResponse response) throws  Exception{

        int resultNum =  newsService.updateInfo(news);
        boolean delFlag;
        if(resultNum==1){
            delFlag = true;
        }else {
            delFlag = false;
        }
        ResponseUtil.write(delFlag,response);
        return null;
    }

}
