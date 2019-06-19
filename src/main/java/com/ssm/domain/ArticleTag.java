package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class ArticleTag implements Serializable{

	private static final long serialVersionUID = 1L;

	private int ID;
	private int ArticleID;	
	private int TagID;
	
	
	private String CreateBy;
	private Date CreateTime;
	private String ModifiedBy;
	private Date ModifiedTime;
	
	private int SecondCategoryID;
	
	public int getSecondCategoryID() {
		return SecondCategoryID;
	}
	public void setSecondCategoryID(int secondCategoryID) {
		SecondCategoryID = secondCategoryID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getArticleID() {
		return ArticleID;
	}
	public void setArticleID(int articleID) {
		ArticleID = articleID;
	}
	public int getTagID() {
		return TagID;
	}
	public void setTagID(int tagID) {
		TagID = tagID;
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
}
