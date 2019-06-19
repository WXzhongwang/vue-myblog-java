package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.ThumbUpRecordDao;
import com.ssm.domain.ThumbUpRecord;
import com.ssm.service.ThumbUpRecordService;



@Service("thumpUpRecordService")
public class ThumbUpRecordServiceImpl implements ThumbUpRecordService{
	@Resource
	private ThumbUpRecordDao thumbUpRecordDao;

	@Override
	public void add(ThumbUpRecord thumbUpRecord) {
		thumbUpRecordDao.add(thumbUpRecord);
	}

	@Override
	public List<ThumbUpRecord> getAll(ThumbUpRecord thumbUpRecord) {
		List<ThumbUpRecord>list  = thumbUpRecordDao.getAll(thumbUpRecord);
		return list;
	}	
	
	@Override
	public boolean hasAlreadyThumbUp(int articleID) {
		ThumbUpRecord thumbUpRecord = null;
		thumbUpRecord = thumbUpRecordDao.hasAlreadyThumbUp(articleID);
		return thumbUpRecord != null ? true: false;		
	}	
}
