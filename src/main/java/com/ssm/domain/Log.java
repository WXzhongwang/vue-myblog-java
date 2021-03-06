package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String LogType;
	private String Message;
	private String ClassType;
	
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
	public String getLogType() {
		return LogType;
	}
	public void setLogType(String logType) {
		LogType = logType;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getClassType() {
		return ClassType;
	}
	public void setClassType(String classType) {
		this.ClassType = classType;
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
