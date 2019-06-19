package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.LogDao;
import com.ssm.domain.Log;
import com.ssm.service.log.LogService;

@Transactional(readOnly = true)
@Service
public class LogServiceImpl implements LogService{
	
	@Autowired
	private LogDao logDao;

	
	@Override
	@Transactional(readOnly = false)
	public void insert(Log log) {
		System.out.println("-------------------logService启动成功---------------");
		logDao.insert(log);			
		System.out.println("-------------------logService日志结束---------------");
	}
}
