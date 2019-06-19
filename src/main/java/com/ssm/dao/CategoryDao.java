package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.domain.Category;

@Repository
public interface CategoryDao {
	public abstract int addCatory(Category category); 
	
	public abstract int updateCategory(Category category);
	
	public abstract int DeleteCategory(int ID);
		
	public abstract List<Category> getAll(Category category);
	
	public abstract Category getCategory(int ID);
	
	public abstract List<Category> getMainCategoryList();
	
	public abstract List<Category> getSubCategoryList(Category category);
}  
