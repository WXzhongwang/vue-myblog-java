package com.ssm.service.impl;

import java.util.Date;
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
import com.ssm.domain.ArticleTag;
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
	@Transactional
	@RunningLog(getLogType = LogType.Info)
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		articleDao.addArticle(article);
		ArticleTag articleTag = null;
		if(article.getTags() != null && article.getTags().size() > 0) {			
			for(Tag tag : article.getTags()) {
				articleTag = new ArticleTag();
				articleTag.setArticleID(article.getID());
				articleTag.setTagID(tag.getID());
				articleTag.setCreateTime(new Date());
				tagDao.addArticleTag(articleTag);
			}			
		}
	}

	@Override
	@Transactional
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		articleDao.updateArticle(article);
		tagDao.deleteArticleTags(article.getID());
		ArticleTag articleTag = null;
		if(article.getTags() != null && article.getTags().size() > 0) {			
			for(Tag tag : article.getTags()) {
				articleTag = new ArticleTag();
				articleTag.setArticleID(article.getID());
				articleTag.setTagID(tag.getID());
				articleTag.setCreateTime(new Date());
				tagDao.addArticleTag(articleTag);
			}			
		}
	}

	@Override
	@Transactional
	public void deleteArticle(int ID) {
		tagDao.deleteArticleTags(ID);
		articleDao.deleteArticle(ID);		
	}

	@Override
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional
	public void thumbUpArticle(int ID) {
		articleDao.thumbUpArticle(ID);
	}
}
