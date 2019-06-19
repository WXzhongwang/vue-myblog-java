package com.ssm.domain;

import java.io.Serializable;

public class Application implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String ID;
	private String Key;
	private String Value;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
}
