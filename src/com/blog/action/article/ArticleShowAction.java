package com.blog.action.article;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.blog.entity.Article;
import com.blog.service.ArticleService;


@Controller@Scope("prototype")
public class ArticleShowAction {
	@Resource ArticleService articleServiceImpl;
	
	private static Logger logger = Logger.getLogger(ArticleShowAction.class);
	private List<Article> articles;
	private List<Article> hotArticles;
	private List<Article> newArticles;
	private List<Article> recommendArticles;
	private int totalPage;
	private int page=1;
	private int pageSize=5; 
	private int size;
	private Integer albumId;//只用于相册模块
	
	public String execute(){
		logger.info("文章浏览");
		size = articleServiceImpl.getSize();
		
		totalPage=size%pageSize==0?size/pageSize:size/pageSize+1;
		articles = articleServiceImpl.getArticles((page-1)*pageSize, pageSize);
		hotArticles = articleServiceImpl.getHotArticles();
		newArticles = articleServiceImpl.getNewArticles();
		recommendArticles = articleServiceImpl.getArticlesByNotice("recommendArticles");
		return "success";
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getHotArticles() {
		return hotArticles;
	}

	public void setHotArticles(List<Article> hotArticles) {
		this.hotArticles = hotArticles;
	}

	public List<Article> getNewArticles() {
		return newArticles;
	}

	public void setNewArticles(List<Article> newArticles) {
		this.newArticles = newArticles;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Article> getRecommendArticles() {
		return recommendArticles;
	}

	public void setRecommendArticles(List<Article> recommendArticles) {
		this.recommendArticles = recommendArticles;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	
	
}
