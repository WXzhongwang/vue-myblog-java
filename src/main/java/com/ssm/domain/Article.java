package com.ssm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
public class Article implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int ID;
	private String Title;	
	private String Content;
	private String Thumbnail;
	private Date PublishTime;
	private int IsHot;
	
	private String CreateBy;
	private Date CreateTime;
	private String ModifiedBy;
	private Date ModifiedTime;
	private String  CategoryID;
	private List<Tag> Tags = new ArrayList<Tag>();
	private int VisitRecordCount;
	private int ThumpUpCount;
	private String State;
	
	public int getVisitRecordCount() {
		return VisitRecordCount;
	}
	public void setVisitRecordCount(int visitRecordCount) {
		VisitRecordCount = visitRecordCount;
	}
	public int getThumpUpCount() {
		return ThumpUpCount;
	}
	public void setThumpUpCount(int thumpUpCount) {
		ThumpUpCount = thumpUpCount;
	}
	public int getIsHot() {
		return IsHot;
	}
	public void setIsHot(int isHot) {
		IsHot = isHot;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getThumbnail() {
		return Thumbnail;
	}	
	public void setThumbnail(String thumbnail) {
		Thumbnail = thumbnail;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getPublishTime() {
		return PublishTime;
	}
	public void setPublishTime(Date publishTime) {
		PublishTime = publishTime;
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
	public List<Tag> getTags() {
		return Tags;
	}
	public void setTags(List<Tag> tags) {
		this.Tags = tags;
	}
	public String getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(String categoryID) {
		this.CategoryID = categoryID;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}	
}
