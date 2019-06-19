package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class ThumbUpRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int ID;
	private String IP;	
	private int ArticleID;
	private Date Time;
	private String City;
	
	private String CreateBy;
	private Date CreateTime;
	private String ModifiedBy;
	private Date ModifiedTime;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getArticleID() {
		return ArticleID;
	}
	public void setArticleID(int articleID) {
		ArticleID = articleID;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
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
