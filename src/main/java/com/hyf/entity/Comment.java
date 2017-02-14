package com.hyf.entity;

import java.util.Date;

public class Comment {

	private int commentId;
	private int newsId;
	private String newsTitle;
	private String content;
	private String userIP;
	private Date commentDate;
	
	private String s_bCommentDate;
	private String s_aCommentDate;

    private String commentIds;
	
	public Comment(int newsId, String content, String userIP) {
		super();
		this.newsId = newsId;
		this.content = content;
		this.userIP = userIP;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserIP() {
		return userIP;
	}
	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getS_bCommentDate() {
		return s_bCommentDate;
	}

	public void setS_bCommentDate(String s_bCommentDate) {
		this.s_bCommentDate = s_bCommentDate;
	}

	public String getS_aCommentDate() {
		return s_aCommentDate;
	}

	public void setS_aCommentDate(String s_aCommentDate) {
		this.s_aCommentDate = s_aCommentDate;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

    public String getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(String commentIds) {
        this.commentIds = commentIds;
    }
}
