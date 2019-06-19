package com.ssm.service;

import java.util.List;

import com.ssm.domain.Article;
import com.ssm.domain.ThumbUpRecord;
import com.ssm.domain.VisitRecord;

public interface ThumbUpRecordService {
	
    public abstract void add(ThumbUpRecord thumbUpRecord); 
	
	public abstract List<ThumbUpRecord> getAll(ThumbUpRecord thumbUpRecord);
	
	public abstract boolean hasAlreadyThumbUp(int id);
	
}
