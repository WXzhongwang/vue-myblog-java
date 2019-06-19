package com.ssm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int ID;
	private String Name;	
	private String Description;
	private String Thumbnail;
	private int ParentCategoryID;
	
	private String CreateBy;
	private Date CreateTime;
	private String ModifiedBy;
	private Date ModifiedTime;
	
	private List<Article> articles = new ArrayList<Article>();
	private List<Category> subCategories = new ArrayList<Category>();
	
	public List<Category> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getThumbnail() {
		return Thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		Thumbnail = thumbnail;
	}
	public int getParentCategoryID() {
		return ParentCategoryID;
	}
	public void setParentCategoryID(int parentCategoryID) {
		ParentCategoryID = parentCategoryID;
	}
	public String getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(String createBy) {
		CreateBy = createBy;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public Date getModifiedTime() {
		return ModifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		ModifiedTime = modifiedTime;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
