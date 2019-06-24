package com.ssm.dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.springframework.stereotype.Repository;

import com.ssm.domain.Article;
import com.ssm.domain.ArticleTag;
import com.ssm.domain.Tag;
import com.ssm.domain.User;

@Repository
public interface TagDao {
	public abstract int addTag(Tag tag); 
	
	public abstract int updateTag(Tag tag);
	
	public abstract int deleteTag(int ID);
	
	public abstract Tag getTag(int ID);
		
	public abstract List<Tag> getAll();
	
	public abstract List<Tag> getArticleTagList(int ArticleID);
	
	public abstract void deleteArticleTags(int ArticleID);
	
	public abstract void addArticleTag(ArticleTag articleTag);
}  
