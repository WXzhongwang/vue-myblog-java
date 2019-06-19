package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.VisitRecordDao;
import com.ssm.domain.Article;
import com.ssm.domain.VisitRecord;
import com.ssm.service.VisitRecordService;



@Transactional(readOnly = true)
@Service("visitRecordService")
public class VisitRecordServiceImpl implements VisitRecordService{
	@Resource
	private VisitRecordDao visitRecordDao;

	@Override
	public void add(VisitRecord visitRecord) {
		// TODO Auto-generated method stub
		visitRecordDao.add(visitRecord);
	}

	@Override
	public List<VisitRecord> getAll(Article article) {
		return visitRecordDao.getAll(article);
	}	
}
