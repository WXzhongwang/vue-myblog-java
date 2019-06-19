package com.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.ApplicationDao;
import com.ssm.domain.Application;
import com.ssm.service.ApplicationService;
import com.ssm.service.log.LogType;
import com.ssm.service.log.RunningLog;


@Transactional(readOnly = true)
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService{
	@Resource
	private ApplicationDao applicationDao;

	@Override
	public void add(Application application) {
		// TODO Auto-generated method stub
		applicationDao.add(application);
	}

	@Override
	@RunningLog(getLogType = LogType.Info)
	@Transactional(readOnly = false)
	public Map<String, String> getApplicationSetting() {
		// TODO Auto-generated method stub
		List<Application>list = applicationDao.getAll();
		Map<String, String>map = new HashMap<String, String>();
		for(Application application :  list) {
			if(!map.containsKey(application.getKey())){
				map.put(application.getKey(), application.getValue());
			}
		}
		return map;
	}

	@Override
	@Transactional(readOnly = false)
	public void update(String name, String individualitySignature, String introduce) {
		// TODO Auto-generated method stub
		applicationDao.updateBlogName(name);
		applicationDao.updateBlogIndividualitySignature(individualitySignature);
		applicationDao.updateBlogIntroduce(introduce);
	}
}
