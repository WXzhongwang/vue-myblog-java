package com.ssm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssm.domain.Article;

@Repository
public interface ArticleDao {
	public abstract void addArticle(Article article); 
	
	public abstract void updateArticle(Article article);
	
	public abstract void deleteArticle(int ID);
	
	public abstract Article getArticle(int ID);
	
	public abstract List<Article> getAll(Article article);
	
	public abstract List<Article> getHotArticles(Article article);
	
	public abstract Map<String, Integer> getSideBar();
	
	public abstract void thumbUpArticle(int ID);
}  
