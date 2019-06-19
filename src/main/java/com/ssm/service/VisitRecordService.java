package com.ssm.service;

import java.util.List;

import com.ssm.domain.Article;
import com.ssm.domain.VisitRecord;

public interface VisitRecordService {
    public abstract void add(VisitRecord visitRecord); 
	
	public abstract List<VisitRecord> getAll(Article article);
	
}
