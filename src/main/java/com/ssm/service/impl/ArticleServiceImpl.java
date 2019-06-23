package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.AbstractDocument.LeafElement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.ArticleDao;
import com.ssm.dao.TagDao;
import com.ssm.domain.Article;
import com.ssm.domain.Tag;
import com.ssm.service.ArticleService;
import com.ssm.service.log.LogType;
import com.ssm.service.log.RunningLog;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
	@Resource
	private ArticleDao articleDao;
	
	@Resource
	private TagDao tagDao;

	@Override	
	@RunningLog(getLogType = LogType.Info)
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		articleDao.addArticle(article);
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		articleDao.updateArticle(article);
	}

	@Override
	public void deleteArticle(int ID) {
		// TODO Auto-generated method stub
		articleDao.deleteArticle(ID);
	}

	@Override
	public Article getArticle(int ID) {
		// TODO Auto-generated method stub		
		Article article = null;
		article = articleDao.getArticle(ID);
		if(article != null) {
			List<Tag> tags = tagDao.getArticleTagList(article.getID());
			article.setTags(tags);
		}		
		return article;
	}

	@Override
	public List<Article> getAll(Article article) {
		// TODO Auto-generated method stub	
		 List<Article>  list =  articleDao.getAll(article);
		 for(Article item:list){
			 List<Tag> tags = tagDao.getArticleTagList(item.getID());
			 item.setTags(tags);
		 }
		return list;
	}

	@Override
	public PageInfo<Article> findByPage(Integer page, Integer size,
			Article article) {
		 PageHelper.startPage(page, size);
		// TODO Auto-generated method stub
		List<Article>  list =  articleDao.getAll(article);
		for(Article item:list){
			 List<Tag> tags = tagDao.getArticleTagList(item.getID());
			 item.setTags(tags);
		}
		PageInfo<Article> pageInfo=new PageInfo<Article>(list);
		return pageInfo;
	}

	@Override
	public Map<String, Integer> getSideBar() {
		return articleDao.getSideBar();
	}

	@Override
	public List<Article> getHotArticles(Article article) {
		// TODO Auto-generated method stub
		List<Article>  list =  articleDao.getHotArticles(article);
		for(Article item:list){
			 List<Tag> tags = tagDao.getArticleTagList(item.getID());
			 item.setTags(tags);
		}
		return list;
	}
	
	@Override
	public void thumbUpArticle(int ID) {
		articleDao.thumbUpArticle(ID);
	}
}
