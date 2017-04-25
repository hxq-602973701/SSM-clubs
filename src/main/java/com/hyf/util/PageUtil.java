package com.hyf.util;

import com.hyf.entity.Comment;
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
			pageCode.append("<p>上一篇： 没有了</p>");
		}if(upNews.getNewsId()==-1){
			pageCode.append("<p>下一篇： 没有了</p>");
		}if(downNews.getNewsId()!=-1){
			pageCode.append("<p>下一篇：<a href='news.do?action=show&newsId="+downNews.getNewsId()+"'>"+downNews.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}

	public static String getPagation(String targetUrl,int totalNum,int currentPage,int pageSize,News news){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		pageCode.append("<li><a href='"+targetUrl+"&page=1'>首页</a></li>");
		if(currentPage==1){
			pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
		}else{
			if(news.getS_aPublishDate()==null && news.getS_bPublishDate()==null && news.getTitle()==null){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage-1)+"'>上一页</a></li>");
			}
			if(news.getTitle()!=null && news.getS_bPublishDate()==null && news.getS_aPublishDate()==null){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage-1)+"&title="+news.getTitle()+"'>上一页</a></li>");
			}
			if(news.getTitle()!=null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()==null){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage-1)+"&title="+news.getTitle
						()+"&s_bPublishDate="+news.getS_bPublishDate()+"'>上一页</a></li>");
			}
			if(news.getTitle()!=null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()!=null) {
				pageCode.append("<li><a href='" + targetUrl + "&page=" + (currentPage - 1) + "&title=" + news.getTitle() + "&s_bPublishDate=" +
						news.getS_bPublishDate() + "&s_aPublishDate=" + news.getS_aPublishDate() + "'>上一页</a></li>");
			}
			if(news.getTitle()==null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()==null){
				pageCode.append("<li><a href='" + targetUrl + "&page=" + (currentPage - 1) + "&s_bPublishDate=" + news.getS_bPublishDate() +
						"'>上一页</a></li>");
			}
			if(news.getTitle()==null && news.getS_bPublishDate()==null && news.getS_aPublishDate()!=null){
				pageCode.append("<li><a href='" + targetUrl + "&page=" + (currentPage - 1) + "&s_aPublishDate=" + news.getS_aPublishDate() +
						"'>上一页</a></li>");
			}
		}

		for(int i=currentPage-2;i<=currentPage+2;i++){
			if(i<1 || i>totalPage){
				continue;
			}
			if(i==currentPage){
				pageCode.append("<li class='active'><a href='#'>"+i+"</a></li>");
			}else{

				if(news.getS_aPublishDate()==null && news.getS_bPublishDate()==null && news.getTitle()==null){
					pageCode.append("<li><a href='"+targetUrl+"&page="+i+"'>"+i+"</a></li>");
				}
				if(news.getTitle()!=null && news.getS_bPublishDate()==null && news.getS_aPublishDate()==null){
					pageCode.append("<li><a href='"+targetUrl+"&page="+i+"&title="+news.getTitle()+"'>"+i+"</a></li>");
				}
				if(news.getTitle()!=null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()==null){
					pageCode.append("<li><a href='"+targetUrl+"&page="+i+"&title="+news.getTitle
							()+"&s_bPublishDate="+news.getS_bPublishDate()+"'>"+i+"</a></li>");
				}
				if(news.getTitle()!=null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()!=null) {
					pageCode.append("<li><a href='" + targetUrl + "&page=" + i + "&title=" + news.getTitle() + "&s_bPublishDate=" +
							news.getS_bPublishDate() + "&s_aPublishDate=" + news.getS_aPublishDate() + "'>"+i+"</a></li>");
				}
				if(news.getTitle()==null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()==null){
					pageCode.append("<li><a href='" + targetUrl + "&page=" + i + "&s_bPublishDate=" + news.getS_bPublishDate() + "'>"+i
							+"</a></li>");
				}
				if(news.getTitle()==null && news.getS_bPublishDate()==null && news.getS_aPublishDate()!=null){
					pageCode.append("<li><a href='" + targetUrl + "&page=" + i + "&s_aPublishDate=" + news.getS_aPublishDate() + "'>"+i
							+"</a></li>");
				}
				//pageCode.append("<li><a href='"+targetUrl+"&page="+i+"'>"+i+"</a></li>");
			}

		}

		if(currentPage==totalPage){
			pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
		}else{
			if(news.getS_aPublishDate()==null && news.getS_bPublishDate()==null && news.getTitle()==null){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage+1)+"'>下一页</a></li>");
			}
			if(news.getTitle()!=null && news.getS_bPublishDate()==null && news.getS_aPublishDate()==null){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage+1)+"&title="+news.getTitle()+"'>下一页</a></li>");
			}
			if(news.getTitle()!=null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()==null){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage+1)+"&title="+news.getTitle
						()+"&s_bPublishDate="+news.getS_bPublishDate()+"'>下一页</a></li>");
			}
			if(news.getTitle()!=null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()!=null) {
				pageCode.append("<li><a href='" + targetUrl + "&page=" + (currentPage+1) + "&title=" + news.getTitle() + "&s_bPublishDate=" +
						news.getS_bPublishDate() + "&s_aPublishDate=" + news.getS_aPublishDate() + "'>下一页</a></li>");
			}
			if(news.getTitle()==null && news.getS_bPublishDate()!=null && news.getS_aPublishDate()==null){
				pageCode.append("<li><a href='" + targetUrl + "&page=" + (currentPage+1) + "&s_bPublishDate=" + news.getS_bPublishDate() + "'>下一页</a></li>");
			}
			if(news.getTitle()==null && news.getS_bPublishDate()==null && news.getS_aPublishDate()!=null){
				pageCode.append("<li><a href='" + targetUrl + "&page=" + (currentPage+1) + "&s_aPublishDate=" + news.getS_aPublishDate() + "'>下一页</a></li>");
			}
			//pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage+1)+"&title="+news.getTitle()+"&s_bPublishDate="+news.getS_bPublishDate()+"&s_aPublishDate="+news.getS_aPublishDate()+"'>下一页</a></li>");
		}
		pageCode.append("<li><a href='"+targetUrl+"&page="+totalPage+"'>尾页</a></li>");
		return pageCode.toString();
	}

	public static String getPagation1(String targetUrl,int totalNum,int currentPage,int pageSize,Comment comment){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		pageCode.append("<li><a href='"+targetUrl+"&page=1'>首页</a></li>");
		if(currentPage==1){
			pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
		}else{
			if(comment.getS_bCommentDate()!=null && comment.getS_aCommentDate()==null || "".equals(comment.getS_aCommentDate())){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage-1)+"&s_bCommentDate="+comment.getS_bCommentDate()+"'>上一页</a></li>");
			}if(comment.getS_bCommentDate()==null && comment.getS_aCommentDate()==null){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage-1)+"'>上一页</a></li>");
			}

		}

		for(int i=currentPage-2;i<=currentPage+2;i++){
			if(i<1 || i>totalPage){
				continue;
			}
			if(i==currentPage){
				pageCode.append("<li class='active'><a href='#'>"+i+"</a></li>");
			}else{
				if(comment.getS_bCommentDate()!=null && comment.getS_aCommentDate()==null || "".equals(comment.getS_aCommentDate()) ){
					pageCode.append("<li><a href='"+targetUrl+"&page="+i+"&s_bCommentDate="+comment.getS_bCommentDate()+"'>"+i+"</a></li>");
				}if(comment.getS_bCommentDate()==null && comment.getS_aCommentDate()==null){
					pageCode.append("<li><a href='"+targetUrl+"&page="+i+"'>"+i+"</a></li>");
				}
				//pageCode.append("<li><a href='"+targetUrl+"&page="+i+"'>"+i+"</a></li>");
			}

		}

		if(currentPage==totalPage){
			pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
		}else{
			if(comment.getS_bCommentDate()!=null && comment.getS_aCommentDate()==null || "".equals(comment.getS_aCommentDate())){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage+1)+"&s_bCommentDate="+comment.getS_bCommentDate()+"'>下一页</a></li>");
			}if(comment.getS_bCommentDate()==null && comment.getS_aCommentDate()==null){
				pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage+1)+"'>下一页</a></li>");
			}
			//pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage+1)+"'>下一页</a></li>");
		}
		pageCode.append("<li><a href='"+targetUrl+"&page="+totalPage+"'>尾页</a></li>");
		return pageCode.toString();
	}
}
