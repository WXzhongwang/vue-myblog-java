package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.CategoryDao;
import com.ssm.domain.Category;
import com.ssm.service.CategoryService;

@Transactional(readOnly = true)
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Resource
	private CategoryDao categoryDao;

	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryDao.addCatory(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryDao.updateCategory(category);
	}

	@Override
	public void delete(int ID) {
		// TODO Auto-generated method stub
		categoryDao.DeleteCategory(ID);
	}

	@Override
	public Category get(int ID) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(ID);
	}

	@Override
	public List<Category> getAll(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.getAll(category);
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		List<Category>list = categoryDao.getMainCategoryList();
		for(Category item : list){
			 List<Category> subCategories = categoryDao.getSubCategoryList(item);
			 item.setSubCategories(subCategories);
		}
		return list;
	}
}
