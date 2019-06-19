package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.domain.ThumbUpRecord;


@Repository
public interface ThumbUpRecordDao {
	
    public abstract void add(ThumbUpRecord thumbUpRecord); 
    
	public abstract List<ThumbUpRecord> getAll(ThumbUpRecord thumbUpRecord);
	
	public abstract ThumbUpRecord hasAlreadyThumbUp(int articleID);
}
