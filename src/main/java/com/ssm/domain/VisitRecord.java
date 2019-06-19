package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class VisitRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String ID;
	private String IP;	
	private String ArticleID;
	private Date Time;
	private String City;
	
	private String CreateBy;
	private Date CreateTime;
	private String ModifiedBy;
	private Date ModifiedTime;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getArticleID() {
		return ArticleID;
	}
	public void setArticleID(String articleID) {
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
