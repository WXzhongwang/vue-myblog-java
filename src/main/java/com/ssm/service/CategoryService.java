package com.ssm.service;

import java.util.List;

import com.ssm.domain.Article;
import com.ssm.domain.Category;

public interface CategoryService {
	public abstract void add(Category category); 
	
	public abstract void update(Category category);
	
	public abstract void delete(int ID);
	
	public abstract Category get(int ID);
	
	public abstract List<Category> getAll(Category category);
	
	public abstract List<Category> getCategories();
}
