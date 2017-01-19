package com.hyf.util;

import com.hyf.entity.News;

import java.util.List;

public class PageUtil {

	public static String getUpAndDownPagation(Long totalNum,int currentPage,int pageSize,int typeId){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		pageCode.append("<ul class='pager'>");
		if(currentPage==1){
			pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
		}else{
			pageCode.append("<li><a href='news.do?action=list&typeId="+typeId+"&page="+(currentPage-1)+"'>上一页</a></li>");
		}
		pageCode.append("&nbsp;&nbsp;");
		if(currentPage==totalPage){
			pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
		}else{
			pageCode.append("<li><a href='news.do?action=list&typeId="+typeId+"&page="+(currentPage+1)+"'>下一页</a></li>");
		}
		pageCode.append("</ul>");
		return pageCode.toString();
	}

	public static String genUpAndDownPageCode(List<News> upPage,List<News> downPage ){
		News upNews=upPage.get(0);
		News downNews=downPage.get(0);
		StringBuffer pageCode=new StringBuffer();
		if(upNews.getNewsId()!=-1){
			pageCode.append("<p>上一篇：<a href='news.do?action=show&newsId="+upNews.getNewsId()+"'>"+upNews.getTitle()+"</a></p>");
		}if(downNews.getNewsId()==-1){
			pageCode.append("<p>下一篇：没有了</p>");
		}if(upNews.getNewsId()==-1){
			pageCode.append("<p>上一篇：没有了</p>");
		}if(downNews.getNewsId()!=-1){
			pageCode.append("<p>下一篇：<a href='news.do?action=show&newsId="+downNews.getNewsId()+"'>"+downNews.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
}
