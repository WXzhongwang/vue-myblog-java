package com.ssm.service;

import java.util.List;

import com.ssm.domain.Tag;

public interface TagService {
	public abstract void addTag(Tag tag); 
	
	public abstract void updateTag(Tag tag);
	
	public abstract void deleteTag(int ID);
	
	public abstract Tag getTag(int ID);
	
	public abstract List<Tag> getAll();
	
	public abstract List<Tag> getArticleTagList(int ArticleID);
}
