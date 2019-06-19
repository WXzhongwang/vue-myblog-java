package com.ssm.service;

import java.util.Map;

import com.ssm.domain.Application;

public interface ApplicationService {
	public abstract void add(Application application);
	public abstract Map<String,String>getApplicationSetting();
	public abstract void update(String name, String individualitySignature, String introduce);
}
