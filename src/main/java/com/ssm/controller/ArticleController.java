package com.ssm.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ssm.base.util.AddressUtil;
import com.ssm.base.util.AjaxResponder;
import com.ssm.base.util.WebServletUtil;
import com.ssm.domain.Article;
import com.ssm.domain.ThumbUpRecord;
import com.ssm.service.ArticleService;
import com.ssm.service.ThumbUpRecordService;

/**
 * Article Controller
 * @author shengwangzhong
 * @date: 2019-064-19 16:28
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/articles")
public class ArticleController {
	@Autowired 
	ArticleService articleService;
	@Autowired 
	ThumbUpRecordService thumbUpRecordService;
		
	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public AjaxResponder add(Article article, HttpServletRequest request, HttpServletResponse response){
		AjaxResponder result = null;		
		article.setThumpUpCount(0);
		article.setVisitRecordCount(0);
		articleService.addArticle(article);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", article);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public AjaxResponder get(@PathVariable("id") Integer id){
		AjaxResponder result = null;
		Article article = articleService.getArticle(id);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", article);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AjaxResponder edit(@ModelAttribute(value="article")Article article) {
		AjaxResponder result = null;
		articleService.updateArticle(article);
		System.out.println(article.getID()+ "+" + article.getContent());
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", article);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public AjaxResponder delete(@PathVariable("id") Integer id) {
		AjaxResponder result = null;
		articleService.deleteArticle(id);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", null);
		return result;
	}	

	@ResponseBody
	@RequestMapping(value = "/hot", method = RequestMethod.GET)
	public AjaxResponder getHot(HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;	
		Article article = new Article();
		//article.setIsHot(1);
		List<Article> articles = articleService.getHotArticles(article);				
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", articles);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public AjaxResponder getAll(Article article,HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;		
		List<Article> articles = articleService.getAll(article);		
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", articles);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public AjaxResponder findByPage(@RequestParam("page")Integer page, @RequestParam("size")Integer size, HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;		
		System.out.println("Page: " + page + ", Size: " + size);
		PageInfo<Article> articles = articleService.findByPage(page, size, null);		
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", articles);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/sidebar", method=RequestMethod.GET)
	public AjaxResponder getSideBar(HttpServletRequest request, HttpServletResponse response){
		AjaxResponder result = null;
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", articleService.getSideBar());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public AjaxResponder getArticleList(HttpServletRequest request, HttpServletResponse response){
		AjaxResponder result = null;
		List<Article> list = articleService.getAll(null);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", list);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/thumbup/{id}", method=RequestMethod.GET)
	public AjaxResponder thumbUp(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response){
		AjaxResponder result = null;
		System.out.println(id);
		if (!thumbUpRecordService.hasAlreadyThumbUp(id)) {
			ThumbUpRecord thumbUpRecord = new ThumbUpRecord();
			thumbUpRecord.setArticleID(id);
			String iPString = WebServletUtil.getClientIpAddress(request);
			System.out.println("IP地址：" + iPString);
			thumbUpRecord.setIP(iPString);
			thumbUpRecord.setCity(AddressUtil.GetAddressByIp(iPString));
			thumbUpRecord.setCreateTime(new Date());
			thumbUpRecord.setTime(new Date());
			thumbUpRecordService.add(thumbUpRecord);
			articleService.thumbUpArticle(id);
			result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", null);
		}else {
			result = AjaxResponder.getInstance(Boolean.FALSE, "查询成功", null);
		}		
		return result;
	}
}
