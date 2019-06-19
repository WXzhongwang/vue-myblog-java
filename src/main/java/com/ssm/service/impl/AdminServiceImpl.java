package com.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.AdminDao;
import com.ssm.service.AdminService;
import com.ssm.service.log.LogType;
import com.ssm.service.log.RunningLog;


@Transactional(readOnly = true)
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Resource
	private AdminDao adminDao;

	@Override
	@RunningLog(getLogType = LogType.Info)
	@Transactional(readOnly = false)
	public boolean adminLogin() {
		return Boolean.FALSE;
	}

}
