package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.AdminDao;
import com.ssm.dao.ArticleDao;
import com.ssm.dao.TagDao;
import com.ssm.domain.Article;
import com.ssm.domain.Tag;
import com.ssm.service.AdminService;
import com.ssm.service.ArticleService;
import com.ssm.service.TagService;
import com.ssm.service.log.LogType;
import com.ssm.service.log.RunningLog;

@Service("tagService")
public class TagServiceImpl implements TagService{
	@Resource
	private TagDao tagDao;

	@Override	
	public void addTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.addTag(tag);
	}

	@Override
	public void updateTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.updateTag(tag);
	}

	@Override
	public void deleteTag(int ID) {
		// TODO Auto-generated method stub
		tagDao.deleteTag(ID);
	}

	@Override
	public Tag getTag(int ID) {
		// TODO Auto-generated method stub		
		return tagDao.getTag(ID);
	}

	@Override
	public List<Tag> getAll() {
		// TODO Auto-generated method stub		
		return tagDao.getAll();
	}

	@Override
	public List<Tag> getArticleTagList(int ArticleID) {
		// TODO Auto-generated method stub
		return tagDao.getArticleTagList(ArticleID);
	}
}
