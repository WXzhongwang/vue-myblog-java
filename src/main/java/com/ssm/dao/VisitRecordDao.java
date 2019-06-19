package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.domain.Article;
import com.ssm.domain.VisitRecord;

@Repository
public interface VisitRecordDao {
    public abstract void add(VisitRecord visitRecord); 
    
	public abstract List<VisitRecord> getAll(Article article);
	
}
