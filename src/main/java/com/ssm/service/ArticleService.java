package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Article;

public interface ArticleService {
	public abstract void addArticle(Article article); 
	
	public abstract void updateArticle(Article article);
	
	public abstract void deleteArticle(int ID);
	
	public abstract Article getArticle(int ID);
	
	public abstract List<Article> getAll(Article article);
	
	public abstract List<Article> getHotArticles(Article article);
	
	public abstract PageInfo<Article> findByPage(Integer page,Integer size,Article article);
	
	public abstract Map<String, Integer> getSideBar();
	
	public abstract void thumbUpArticle(int ID);
}
