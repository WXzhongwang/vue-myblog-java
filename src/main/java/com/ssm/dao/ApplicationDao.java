package com.ssm.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.domain.Application;

@Repository
public interface ApplicationDao {
	public abstract void add(Application application);
	public abstract List<Application>getAll();	
	public abstract void updateBlogName(String name);
	public abstract void updateBlogIndividualitySignature(String individualitySignature);
	public abstract void updateBlogIntroduce(String introduce);
}


 
